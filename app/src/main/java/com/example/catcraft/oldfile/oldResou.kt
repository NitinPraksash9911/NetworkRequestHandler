package com.example.catcraft.oldfile


//sealed class Resource<out T> {
//    data class Success<out T>(val value: T) : Resource<T>()
//    object InvalidData : Resource<Nothing>()
//    data class NetworkException(val error: String) : Resource<Nothing>()
//    data class Error(val error: String) : Resource<Nothing>()
//
//    sealed class HttpErrors : Resource<Nothing>() {
//        data class ResourceForbidden(val exception: String) : HttpErrors()
//        data class ResourceNotFound(val exception: String) : HttpErrors()
//        data class InternalServerError(val exception: String) : HttpErrors()
//        data class BadGateWay(val exception: String) : HttpErrors()
//        data class ResourceRemoved(val exception: String) : HttpErrors()
//        data class RemovedResourceFound(val exception: String) : HttpErrors()
//    }
//
//}