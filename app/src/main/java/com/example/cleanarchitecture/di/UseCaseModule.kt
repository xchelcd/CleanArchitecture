package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repository.HomeRepository
import com.example.cleanarchitecture.domain.Login
import com.example.cleanarchitecture.data.repository.LoginRepository
import com.example.cleanarchitecture.domain.GetAllPost
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerLoginCase(
        repository: LoginRepository
    ): Login = Login(repository)

    @Singleton
    @Provides
    fun providerHomeCase(
        repository: HomeRepository
    ): GetAllPost = GetAllPost(repository)
}