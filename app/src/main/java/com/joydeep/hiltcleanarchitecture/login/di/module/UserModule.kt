package com.joydeep.hiltcleanarchitecture.login.di.module

import android.content.SharedPreferences
import com.joydeep.data.di.scope.LoggedInScope
import com.joydeep.data.repositoryImpl.UserDataRepositoryImpl
import com.joydeep.domain.repository.UserDataRepository
import com.joydeep.hiltcleanarchitecture.login.di.component.UserComponent
import com.joydeep.hiltcleanarchitecture.login.entity.LoggedInUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(UserComponent::class)
class UserModule {
    @Provides
    @LoggedInScope
    fun providesUserData(preferences: SharedPreferences): LoggedInUser{
        return LoggedInUser(preferences.getString("username", "Joydeep")!!)
    }

    @Provides
    @LoggedInScope
    fun providesUserDataRepository(userDataRepository: UserDataRepositoryImpl): UserDataRepository {
        return userDataRepository
    }
}