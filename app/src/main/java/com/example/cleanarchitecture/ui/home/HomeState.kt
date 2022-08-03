package com.example.cleanarchitecture.ui.home

import com.example.cleanarchitecture.data.model.Post

data class HomeState(
    val loading: Boolean = true,
    val list: List<Post> = emptyList(),
    val post: Post? = null
) {

    fun updateLoading(b: Boolean): HomeState = copy(loading = b)
    fun updateList(list: List<Post>): HomeState = copy(list = list)
    fun updateData(post: Post): HomeState = copy(post = post)
}