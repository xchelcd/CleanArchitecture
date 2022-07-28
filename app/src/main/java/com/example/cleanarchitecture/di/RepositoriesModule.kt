package com.example.cleanarchitecture.di

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

}