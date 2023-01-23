package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.data.repository.HomeRepository
import com.example.cleanarchitecture.util.WrapperResponse
import javax.inject.Inject

class GetAllPost @Inject constructor(
    private val repository: HomeRepository
){
    suspend operator fun invoke(): WrapperResponse<List<Post>>{
        val loginResponse = repository.getAllPost()

        return loginResponse
    }
}