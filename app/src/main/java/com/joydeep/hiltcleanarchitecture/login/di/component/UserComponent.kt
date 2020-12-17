package com.joydeep.hiltcleanarchitecture.login.di.component

import com.joydeep.data.login.di.scope.LoggedInScope
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@LoggedInScope
@DefineComponent(parent = SingletonComponent::class)
interface UserComponent {
    @DefineComponent.Builder
    interface Factory {
        fun create(): UserComponent
    }
}