package com.example.cleanarchitecture.data.network

import com.example.cleanarchitecture.data.model.User
import com.example.cleanarchitecture.util.Error
import com.example.cleanarchitecture.util.WrapperResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val apiClient: ApiClient
) {

    suspend fun login(user: User): WrapperResponse<User> =
        withContext(IO) {
            delay(2000)
            var wrapperResponse: WrapperResponse<User>
            try {
                //val response = api.login(user)
                val user = User("xchel", "Carrana")
                wrapperResponse = if (user == null) {
                    WrapperResponse(
                        error = Error(
                            errorMessage = "The response body was null"
                        )
                    )
                } else {
                    WrapperResponse(
                        //result = response.body()
                        result = user
                    )
                }
            } catch (e: Exception) {
                wrapperResponse = WrapperResponse(
                    error = Error(
                        errorMessage = e.message.toString()
                    )
                )
            }
            wrapperResponse
        }

}