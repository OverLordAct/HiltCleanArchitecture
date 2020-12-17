package com.joydeep.domain.login.repository

import com.joydeep.domain.login.entity.UserResponse
import com.joydeep.domain.login.entity.UsersResponse

interface UserRepository {
    suspend fun getUsers(page: Int): UsersResponse

    suspend fun getUser(userId: Int): UserResponse
}