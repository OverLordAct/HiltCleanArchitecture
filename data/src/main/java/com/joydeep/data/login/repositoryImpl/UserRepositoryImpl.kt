package com.joydeep.data.login.repositoryImpl

import com.joydeep.data.login.api.Api
import com.joydeep.domain.login.entity.UserResponse
import com.joydeep.domain.login.entity.UsersResponse
import com.joydeep.domain.login.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: Api): UserRepository {
    override suspend fun getUsers(page: Int): UsersResponse {
        return api.getUsers(page)
    }

    override suspend fun getUser(userId: Int): UserResponse {
        return api.getUser(userId)
    }
}