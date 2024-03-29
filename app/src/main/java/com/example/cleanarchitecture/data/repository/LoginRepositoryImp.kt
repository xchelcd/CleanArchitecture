package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.database.UserLocalDataSource
import com.example.cleanarchitecture.data.model.User
import com.example.cleanarchitecture.data.network.UserRemoteDataSource
import com.example.cleanarchitecture.util.Resource
import com.example.cleanarchitecture.util.WrapperResponse
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource,
) : LoginRepository {

    override suspend fun remoteLogin(user: User): Resource =
        remoteDataSource.login(user)

    //override suspend fun checkCredentials(userName: String, password: String): WrapperResponse<User> {
//
    //}
}