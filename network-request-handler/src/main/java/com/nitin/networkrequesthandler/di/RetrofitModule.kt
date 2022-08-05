package com.nitin.networkrequesthandler.di

import com.google.gson.GsonBuilder
import com.nitin.networkrequesthandler.BuildConfig
import com.nitin.networkrequesthandler.interceptor.LoggingInterceptor
import com.nitin.networkrequesthandler.interceptor.NetworkCacheInterceptor
import com.nitin.networkrequesthandler.interceptor.NetworkStatusInterceptor
import com.nitin.networkrequesthandler.interceptor.OfflineCacheInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun getGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        networkStatusInterceptor: NetworkStatusInterceptor,
        networkCacheInterceptor: NetworkCacheInterceptor,
        offlineCacheInterceptor: OfflineCacheInterceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(networkStatusInterceptor)//1
            .apply {
                if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)//2
            }
            .addNetworkInterceptor(networkCacheInterceptor)//3
            .addInterceptor(offlineCacheInterceptor)//4
            .readTimeout(15, SECONDS)
            .writeTimeout(15, SECONDS)
            .connectTimeout(15, SECONDS)
            .build()


    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(loggingInterceptor)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


}