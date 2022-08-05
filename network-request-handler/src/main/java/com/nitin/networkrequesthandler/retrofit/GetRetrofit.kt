package com.nitin.networkrequesthandler.retrofit

import android.content.Context
import dagger.hilt.android.EntryPointAccessors
import retrofit2.Retrofit

object GetRetrofit {

    fun getRetrofitInstance(baseUrl: String, appContext: Context): Retrofit {
        val entryPoint =
            EntryPointAccessors.fromApplication(appContext, RetrofitEntryPoint::class.java)
        return Retrofit.Builder()
            .client(entryPoint.okHttpClient)
            .addConverterFactory(entryPoint.gsonConverterFactory)
            .baseUrl(baseUrl)
            .build()
    }
}