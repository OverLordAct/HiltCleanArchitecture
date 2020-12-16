package com.joydeep.hiltcleanarchitecture.splash.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joydeep.hiltcleanarchitecture.login.di.handler.UserComponentHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivityViewModel @ViewModelInject constructor(
    userComponentHandler: UserComponentHandler
) : ViewModel() {

    var loginStatusLiveData = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch {
            delay(2000)
            loginStatusLiveData.value = userComponentHandler.isLoggedIn()
        }
    }
}