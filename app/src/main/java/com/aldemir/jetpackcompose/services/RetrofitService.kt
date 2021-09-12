package com.aldemir.jetpackcompose.services

import com.aldemir.jetpackcompose.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("users")
    suspend fun getUserList(@Query("page") page: Int) : UserResponse
}