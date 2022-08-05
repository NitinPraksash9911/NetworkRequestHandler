package com.example.catcraft.di

import android.content.Context
import com.example.catcraft.BuildConfig
import com.nitin.networkrequesthandler.retrofit.GetRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit =
        GetRetrofit.getRetrofitInstance(BuildConfig.BASE_URL, context)

}