package com.example.cleanarchitecture.util

data class WrapperResponse<T>(
    val result: T? = null,
    val error: Error? = null,
)

data class Error(
    val errorMessage: String = "",
    val statusCode: Int = 0,
    val details: String = "",
)