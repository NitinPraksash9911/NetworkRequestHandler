package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.nitin.networkrequesthandler.datasource.model.NetworkResource

interface IDataCatBreedRepository {
    suspend fun getCatBreedList(): NetworkResource<List<CatBreedData>>
    suspend fun getDataFromLocal(): NetworkResource<List<CatBreedData>>

}