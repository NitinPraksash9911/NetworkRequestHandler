package com.nitin.networkrequesthandler.datasource.model

sealed class ErrorStatus {
    object HTTPError : ErrorStatus()
    object NetworkError : ErrorStatus()
    object GotException : ErrorStatus()
    object InvalidError : ErrorStatus()
    object ServerError : ErrorStatus()
}


//sealed class HttpErrors<out T> : Resource<T>() { // data class ResourceForbidden<T>(val exception:
//T) : HttpErrors<T>()
// data class ResourceNotFound<T>(val exception: T) : HttpErrors<T>()
// data class InternalServerError<T>(val exception: T) : HttpErrors<T>()
// data class BadGateWay<T>(val exception: T) : HttpErrors<T>()
// data class ResourceRemoved<T>(val exception: T) : HttpErrors<T>()
// data class RemovedResourceFound<T>(val exception: T) : HttpErrors<T>()
// data class InvalidData<T>(val exception: T) : HttpErrors<T>()
// data class NetworkException<T>(val exception: T) : HttpErrors<T>()
//}
