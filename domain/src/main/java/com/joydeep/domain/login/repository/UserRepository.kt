package com.joydeep.domain.login.repository

import com.joydeep.domain.login.entity.Users

interface UserRepository {
    suspend fun getUsers(page: Int): Users

    suspend fun getUser(userId: Int): Users.User
}