package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.nitin.networkrequesthandler.datasource.model.NetworkResource
import com.nitin.networkrequesthandler.utils.executeRetrofitApi

class DataCatBreedRepository(
    private val localCateBreedRepository: LocalCateBreedRepository,
    private val remoteCatBreedRepository: RemoteCatBreedRepository
) : IDataCatBreedRepository {


    override suspend fun getCatBreedList(): NetworkResource<List<CatBreedData>> {
        return remoteCatBreedRepository.getCatBreedList()
    }

    override suspend fun getDataFromLocal(): NetworkResource<List<CatBreedData>> {
        return executeRetrofitApi {
            localCateBreedRepository.getDataLocal()
        }

    }
}