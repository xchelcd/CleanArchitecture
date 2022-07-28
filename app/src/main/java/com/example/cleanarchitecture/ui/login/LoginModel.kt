package com.example.cleanarchitecture.ui.login

import androidx.lifecycle.*
import com.example.cleanarchitecture.data.model.User
import com.example.cleanarchitecture.domain.Login
import com.example.cleanarchitecture.util.WrapperResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val login: Login
) : ViewModel() {


    private var _state = MutableLiveData(LoginState())
    val state: LiveData<LoginState> = _state


    fun tryLogin(callback: (LoginState) -> Unit, onSuccessful: () -> Unit) {
        viewModelScope.launch {
            updateLoading(true)
            state.value?.let(callback)
            try {
                val userName = state.value?.userName?.trim() ?: ""
                val password = state.value?.password?.trim() ?: ""
                val response: WrapperResponse<User>? = login(userName, password)
                onSuccessful()
            } catch (e: Exception) {

            } finally {
                updateLoading(false)
                state.value?.let(callback)
            }
        }
    }

    private fun updateLoading(b: Boolean) {
        _state.value = state.value?.updateLoading(b)
    }

    fun setPassword(password: String) {
        _state.value = state.value?.updatePassword(password)
    }

    fun setUserName(userName: String) {
        _state.value = state.value?.updateUserName(userName)
    }

}