package com.joydeep.data.repositoryImpl

import com.joydeep.data.di.scope.LoggedInScope
import com.joydeep.domain.repository.UserDataRepository
import javax.inject.Inject
import kotlin.random.Random

@LoggedInScope
class UserDataRepositoryImpl @Inject constructor() : UserDataRepository {
    override var unreadNotification: Int = 0

    init {
        unreadNotification = refreshNotification()
    }

    override fun refreshNotification(): Int {
        val newNotification = Random.nextInt(until = 200)
        unreadNotification = newNotification
        return newNotification
    }
}