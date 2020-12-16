package com.joydeep.hiltcleanarchitecture.account.view.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joydeep.hiltcleanarchitecture.login.di.handler.UserComponentHandler

class AccountActivityViewModel @ViewModelInject constructor(
//    private val userDataRepository: UserDataRepository,
    private val userComponentHandler: UserComponentHandler
) : ViewModel() {

    var notificationLiveData = MutableLiveData<Int>()

    fun logout() {
//        userComponentHandler.logout()
    }

    fun refreshNotification() {
//        notificationLiveData.value = userDataRepository.refreshNotification()
    }
}