package com.example.cleanarchitecture.ui.login

import com.example.cleanarchitecture.data.model.User

data class LoginState(
    val loading: Boolean = true,
    val password: String = "",
    val userName: String = "",
    val user: User? = null
) {

    fun updateLoading(b: Boolean): LoginState = copy(loading = b)
    fun updatePassword(password: String) = copy(password = password)
    fun updateUserName(userName: String) = copy(userName = userName)
    fun updateUser(user: User?) = copy(user = user)
}