package com.joydeep.hiltcleanarchitecture.login.di.handler

interface UserComponentHandler {
    fun login(username: String, password: String)

    fun logout()
}