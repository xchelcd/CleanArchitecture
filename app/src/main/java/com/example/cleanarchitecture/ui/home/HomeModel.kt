package com.example.cleanarchitecture.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.domain.GetAllPost
import com.example.cleanarchitecture.util.WrapperResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    private val getAllPost: GetAllPost
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        fetchAllPost()
    }

    private fun fetchAllPost() = viewModelScope.launch {
        setLoading(true)
        try {
            getAllPost().also(::updateList)
        } catch (e: Exception) {

        } finally {
            setLoading(false)
        }
    }

    private fun updateList(response: WrapperResponse<List<Post>>) {
        val list: List<Post>? = response.result
        if (!list.isNullOrEmpty())
            _state.value = state.value.updateList(list)
        //else _state.value = _state.value.updateMessage("La lista está vacía")
    }

    private fun setLoading(isLoading: Boolean) {
        _state.value = _state.value.updateLoading(isLoading)
    }
}