package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Response
import javax.inject.Inject

@ViewModelScoped
class LocalCateBreedRepository @Inject constructor(
//    private val dao: BreadDao
) {

    suspend fun getLocalData() {
//        getResult {
//            getDataLocal()
//        }
    }


    suspend fun getDataLocal(): Response<List<CatBreedData>> {
        return Response.success(listOf(CatBreedData("1", null, "name", "asda", "asdas")))
    }

}