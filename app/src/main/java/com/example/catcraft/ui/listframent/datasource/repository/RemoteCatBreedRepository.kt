package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.ui.listframent.datasource.apis.CatBreedService
import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.nitin.networkrequesthandler.datasource.model.NetworkResource
import com.nitin.networkrequesthandler.utils.executeRetrofitApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RemoteCatBreedRepository @Inject constructor(
    private var breedService: CatBreedService
) {

    suspend fun getCatBreedList(): NetworkResource<List<CatBreedData>> {
        return executeRetrofitApi {
            breedService.getCatBreedList()
        }
    }
}