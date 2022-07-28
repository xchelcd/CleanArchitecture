package com.example.cleanarchitecture.ui.login

data class LoginState(
    val loading: Boolean = true,
    val password: String = "",
    val userName: String = ""
) {

    fun updateLoading(b: Boolean): LoginState = copy(loading = b)
    fun updatePassword(password: String) = copy(password = password)
    fun updateUserName(userName: String) = copy(userName = userName)
}