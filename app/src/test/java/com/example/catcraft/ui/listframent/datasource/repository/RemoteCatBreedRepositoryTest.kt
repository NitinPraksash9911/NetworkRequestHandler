package com.example.catcraft.ui.listframent.datasource.repository

import com.example.catcraft.arch.Resource
import com.example.catcraft.ui.listframent.datasource.apis.CatBreedService
import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RemoteCatBreedRepositoryTest {

    @MockK
    private lateinit var breedApi: CatBreedService

    @MockK
    private lateinit var breedRemoteRepository: IDataCatBreedRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        val remoteRepo = RemoteCatBreedRepository(breedApi)
        val localRepo = LocalCateBreedRepository()
//        breedRemoteRepository = DataCatBreedRepository(remoteRepo,localRepo)
    }

    @Test
    fun `success from server should return the breed list`() {

        val response = Response.success(FakeBreedData.getBreedList())

        coEvery { breedApi.getCatBreedList() } returns response

        runBlocking {
            val result = breedRemoteRepository.getCatBreedList()
            assertEquals(Resource.Success(response.body()), result)
        }

    }

    @Test
    fun `success from server but return empty list`() {

        val response = Response.success(FakeBreedData.getEmptyBreedData())

        coEvery { breedApi.getCatBreedList() } returns response

        runBlocking {
            val result = breedRemoteRepository.getCatBreedList()
            assertEquals(Resource.Success(response.body()), result)
        }
    }

    @Test
    fun `failure from server should return error`() {

        val response = Response.error<List<CatBreedData>>(401, Companion.create(null, ""))

        coEvery { breedApi.getCatBreedList() } returns response

        runBlocking {
            val result = breedRemoteRepository.getCatBreedList()
            assertEquals(Resource.Error(response.message()), result)
        }

    }

}