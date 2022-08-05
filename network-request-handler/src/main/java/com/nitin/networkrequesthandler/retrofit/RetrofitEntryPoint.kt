package com.nitin.networkrequesthandler.retrofit

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory

@EntryPoint
@InstallIn(SingletonComponent::class)
interface RetrofitEntryPoint {
    val okHttpClient: OkHttpClient
    val gsonConverterFactory: GsonConverterFactory
}