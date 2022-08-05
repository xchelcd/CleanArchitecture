package com.example.cleanarchitecture.util

data class WrapperResponse<T>(
    val result: T? = null,
    val error: Error? = null,
)

data class Error(
    val errorMessage: String = "UnknownError",
    val statusCode: Int = 400,
    val details: String = "Unknown error",
)