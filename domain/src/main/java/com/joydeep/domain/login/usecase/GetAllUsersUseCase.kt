package com.joydeep.domain.login.usecase

import com.joydeep.domain.common.usecase.BaseUseCase
import com.joydeep.domain.login.entity.Users
import com.joydeep.domain.login.repository.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<Int, Users> {
    override suspend fun execute(params: Int, callback: BaseUseCase.Callback<Users>) {
        try {
            val result = userRepository.getUsers(params)
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}