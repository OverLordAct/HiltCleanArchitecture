package com.joydeep.domain.login.usecase

import com.joydeep.domain.common.usecase.BaseUseCase
import com.joydeep.domain.login.entity.Users
import com.joydeep.domain.login.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<Int, Users.User> {
    override suspend fun execute(params: Int, callback: BaseUseCase.Callback<Users.User>) {
        try {
            val result = userRepository.getUser(params)
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}