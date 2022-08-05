package com.nitin.networkrequesthandler.datasource.model

import okhttp3.ResponseBody


data class ErrorResponse(
    val responseCode: Int? = 0,
    val retrofitErrorResponse: ResponseBody? = null,
    val errorStatus: ErrorStatus,
    val exception: Throwable? = null,
)