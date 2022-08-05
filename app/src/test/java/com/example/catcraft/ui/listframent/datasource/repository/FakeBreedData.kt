package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.example.catcraft.ui.listframent.datasource.model.CatBreedData.Image

object FakeBreedData {

    fun getBreedList() = listOf(
        CatBreedData(
            id = "ab",
            Image("ab1", "www.testurl.com"),
            "Breed1",
            "Description1",
            "Origin1",

            ),
        CatBreedData(
            id = "ab1",
            Image("ab2", "www.testurl.com"),
            "Breed2",
            "Description2",
            "Origin2",

            ),
        CatBreedData(
            id = "ab3",
            Image("ab3", "www.testurl.com"),
            "Breed3",
            "Description3",
            "Origin3",

            ),
        CatBreedData(
            id = "ab4",
            Image("ab4", "www.testurl.com"),
            "Breed4",
            "Description4",
            "Origin4",

            ),
        CatBreedData(
            id = "ab5",
            Image("ab5", "www.testurl.com"),
            "Breed5",
            "Description5",
            "Origin5",

            ),
        CatBreedData(
            id = "ab6",
            Image("ab6", "www.testurl.com"),
            "Breed6",
            "Description6",
            "Origin6",

            )
    )

    fun getEmptyBreedData() = listOf<CatBreedData>()
}