package com.joydeep.data.repositoryImpl

import com.joydeep.data.api.Api
import com.joydeep.domain.entity.Users
import com.joydeep.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: Api): UserRepository {
    override suspend fun getUsers(page: Int): Users {
        return api.getUsers(page)
    }

    override suspend fun getUser(userId: Int): Users.User {
        return api.getUser(userId)
    }
}