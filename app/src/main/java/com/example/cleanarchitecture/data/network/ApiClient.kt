package com.example.cleanarchitecture.data.network

import com.example.cleanarchitecture.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiClient {

    @POST("user")
    suspend fun login(
        @Body user: User
    ): Response<User>

    //@GET("post/5")

}