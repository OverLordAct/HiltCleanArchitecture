package com.joydeep.hiltcleanarchitecture.login.di.handler

import android.content.SharedPreferences
import com.joydeep.hiltcleanarchitecture.login.di.component.UserComponent
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserComponentHandlerImpl @Inject constructor(
    private val userComponentFactory: UserComponent.Factory,
    private val preferences: SharedPreferences
) : GeneratedComponentManager<UserComponent>, UserComponentHandler {

    var userComponent: UserComponent? = null
        private set

    init {
        if (isLoggedIn()) {
            userComponent = userComponentFactory.create()
        }
    }

    override fun generatedComponent(): UserComponent {
        return userComponent!!
    }

    override fun login(username: String, password: String) {
        userComponent = userComponentFactory.create()
        preferences.edit()
            .putString("username", username)
            .putString("password", password)
            .apply()
    }

    override fun logout() {
        userComponent = null
        preferences.edit()
            .remove("username")
            .remove("password")
            .apply()
    }

    override fun isLoggedIn(): Boolean {
        val username = preferences.getString("username", "")
        return !username?.isEmpty()!!
    }
}