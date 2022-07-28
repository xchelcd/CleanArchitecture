package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.network.ApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    private val apiClient: OkHttpClient by lazy {
        val interceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    fun myApi(baseUrl: String): ApiClient = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(apiClient)
        .build()
        .create(ApiClient::class.java)
}