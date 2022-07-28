package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.di.ApiProvider.myApi
import com.example.cleanarchitecture.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providerApi(@ApplicationContext context: Context): ApiClient {
        val baseURL = "http://google.com"
        return myApi(baseURL)
    }
}