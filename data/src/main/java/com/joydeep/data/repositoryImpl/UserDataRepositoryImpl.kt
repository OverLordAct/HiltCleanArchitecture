package com.joydeep.data.repositoryImpl

import com.joydeep.data.di.scope.LoggedInScope
import com.joydeep.domain.repository.UserDataRepository
import javax.inject.Inject
import kotlin.random.Random

@LoggedInScope
class UserDataRepositoryImpl @Inject constructor(): UserDataRepository {
    var unreadNotification: Int = Random.nextInt(until = 200)

    override fun refreshNotification(): Int = Random.nextInt(until = 200)
}