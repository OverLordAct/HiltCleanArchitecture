package com.joydeep.data.login.api

import com.joydeep.domain.login.entity.UserResponse
import com.joydeep.domain.login.entity.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/api/users")
    suspend fun getUsers(@Query("page") page: Int): UsersResponse

    @GET("/api/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserResponse
}