package com.joydeep.domain.repository

interface UserDataRepository {
    var unreadNotification: Int

    fun refreshNotification(): Int
}