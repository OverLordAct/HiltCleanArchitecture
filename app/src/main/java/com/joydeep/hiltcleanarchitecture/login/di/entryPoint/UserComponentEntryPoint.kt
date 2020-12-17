package com.joydeep.hiltcleanarchitecture.login.di.entryPoint

import com.joydeep.domain.login.repository.UserDataRepository
import com.joydeep.hiltcleanarchitecture.login.di.component.UserComponent
import com.joydeep.hiltcleanarchitecture.login.entity.LoggedInUser
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(UserComponent::class)
interface UserComponentEntryPoint {
    fun getLoggedInUser(): LoggedInUser
    fun getUserDataRepository(): UserDataRepository
}