package com.joydeep.domain.repository

import com.joydeep.domain.entity.Users

interface UserRepository {
    suspend fun getUsers(page: Int): Users

    suspend fun getUser(userId: Int): Users.User
}