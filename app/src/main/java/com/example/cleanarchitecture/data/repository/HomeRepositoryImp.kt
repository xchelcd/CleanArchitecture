package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.model.Post
import com.example.cleanarchitecture.data.network.UserRemoteDataSource
import com.example.cleanarchitecture.util.WrapperResponse
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
): HomeRepository {
    override suspend fun getAllPost(): WrapperResponse<List<Post>> {
        return remoteDataSource.getAllPost()
    }

}