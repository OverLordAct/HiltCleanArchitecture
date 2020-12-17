package com.joydeep.domain.login.usecase

import com.joydeep.domain.common.usecase.BaseUseCase
import com.joydeep.domain.login.entity.UserResponse
import com.joydeep.domain.login.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) :
    BaseUseCase<Int, UserResponse> {
    override suspend fun execute(params: Int, callback: BaseUseCase.Callback<UserResponse>) {
        try {
            val result = userRepository.getUser(params)
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}