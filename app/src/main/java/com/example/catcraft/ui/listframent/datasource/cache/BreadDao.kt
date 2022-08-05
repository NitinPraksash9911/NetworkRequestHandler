package com.example.catcraft.ui.listframent.datasource.cache

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData

interface BreadDao {

    suspend fun getBreedData(): List<CatBreedData>
}