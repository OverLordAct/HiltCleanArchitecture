package com.joydeep.domain.usecase

import com.joydeep.domain.entity.Users
import com.joydeep.domain.repository.UserRepository
import java.lang.Exception
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository): BaseUseCase<Int, Users> {
    override suspend fun execute(params: Int, callback: BaseUseCase.Callback<Users>) {
        try {
            val result = userRepository.getUsers(params)
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}