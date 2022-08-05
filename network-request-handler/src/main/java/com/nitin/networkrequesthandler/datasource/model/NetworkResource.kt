package com.nitin.networkrequesthandler.datasource.model

sealed class NetworkResource<out T> {
    data class Success<out T>(val data: T) : NetworkResource<T>()
    data class Error<out T>(
        val errorResponse: ErrorResponse
    ) : NetworkResource<T>()
}


