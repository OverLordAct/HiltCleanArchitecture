package com.joydeep.hiltcleanarchitecture.main.viewmodel

sealed class UserStatus<out R> {
    object Loading: UserStatus<Nothing>()

    data class Success<out R>(val data: R): UserStatus<R>()

    data class Failure(val message: String): UserStatus<Nothing>()
}