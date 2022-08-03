package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.repository.HomeRepository
import com.example.cleanarchitecture.data.repository.HomeRepositoryImp
import com.example.cleanarchitecture.data.repository.LoginRepository
import com.example.cleanarchitecture.data.repository.LoginRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Singleton
    @Binds
    abstract fun providerLoginRepository(
        repositoryImpl: LoginRepositoryImp
    ): LoginRepository

    @Singleton
    @Binds
    abstract fun providerHomeRepository(
        repositoryImpl: HomeRepositoryImp
    ): HomeRepository

}