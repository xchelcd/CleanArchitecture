package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.model.User
import com.example.cleanarchitecture.util.Resource
import com.example.cleanarchitecture.util.WrapperResponse

interface LoginRepository {
    suspend fun remoteLogin(user: User): Resource
    //suspend fun checkCredentials(user: User): WrapperResponse<User>
}