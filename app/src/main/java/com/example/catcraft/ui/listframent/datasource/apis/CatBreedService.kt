package com.example.catcraft.ui.listframent.datasource.apis

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.nitin.networkrequesthandler.utils.Cacheable
import retrofit2.Response
import retrofit2.http.GET


interface CatBreedService {

    @GET("v1/breeds")
    @Cacheable
    suspend fun getCatBreedList(): Response<List<CatBreedData>>
}