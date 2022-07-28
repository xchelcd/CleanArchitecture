package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.domain.Login
import com.example.cleanarchitecture.data.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providerLoginCase(
        repository: LoginRepository
    ): Login = Login(repository)
}