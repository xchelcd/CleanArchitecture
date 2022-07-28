package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.data.model.User
import com.example.cleanarchitecture.data.repository.LoginRepository
import com.example.cleanarchitecture.util.WrapperResponse
import javax.inject.Inject

class Login @Inject constructor(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(userName: String, password: String): WrapperResponse<User>? {
        if (userName.isBlank() || password.isBlank()) return null
        val user = User(userName, password)
        return repository.remoteLogin(user)
    }

}