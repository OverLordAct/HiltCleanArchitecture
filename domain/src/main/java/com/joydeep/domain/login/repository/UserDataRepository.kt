package com.joydeep.domain.login.repository

interface UserDataRepository {
    var unreadNotification: Int

    fun refreshNotification(): Int
}