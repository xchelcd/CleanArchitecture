package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.util.WrapperResponse

interface HomeRepository {
    suspend fun getAllPost(): WrapperResponse<List<Post>>
}