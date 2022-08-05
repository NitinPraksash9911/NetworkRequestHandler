package com.example.catcraft.oldfile

//
//import com.example.catcraft.arch.Resource
//import retrofit2.Response
//
//suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
//
//    return try {
//        val response = call()
//        if (response.isSuccessful) {
//            val body = response.body()
//            if (body != null) {
//                Resource.Success(body)
//            } else {
//                Resource.InvalidData
//            }
//        } else {
//            when (response.code()) {
//                403 -> Resource.HttpErrors.ResourceForbidden(response.message())
//                404 -> Resource.HttpErrors.ResourceNotFound(response.message())
//                500 -> Resource.HttpErrors.InternalServerError(response.message())
//                502 -> Resource.HttpErrors.BadGateWay(response.message())
//                301 -> Resource.HttpErrors.ResourceRemoved(response.message())
//                302 -> Resource.HttpErrors.RemovedResourceFound(response.message())
//                else -> Resource.Error(response.message())
//            }
//        }
//    } catch (throwable: Throwable) {
//        Resource.NetworkException(throwable.localizedMessage!!)
//    }
//
//}



