package com.joydeep.hiltcleanarchitecture.dashboard.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joydeep.domain.repository.UserDataRepository
import com.joydeep.hiltcleanarchitecture.login.di.entryPoint.UserComponentEntryPoint
import com.joydeep.hiltcleanarchitecture.login.di.handler.UserComponentHandler
import com.joydeep.hiltcleanarchitecture.login.entity.LoggedInUser
import dagger.hilt.EntryPoints

class DashBoardActivityViewModel @ViewModelInject constructor(
    private val userComponentHandler: UserComponentHandler
) : ViewModel() {
    var userDataLiveData = MutableLiveData<LoggedInUser>()
    var notificationLiveData = MutableLiveData<Int>()
    private var userDataRepository: UserDataRepository

    init {
        val entryPoint = EntryPoints.get(userComponentHandler, UserComponentEntryPoint::class.java)
        userDataLiveData.value = entryPoint.getLoggedInUser()
        userDataRepository = entryPoint.getUserDataRepository()

        userDataRepository.refreshNotification()
        Log.d("REPOSITORY", userDataRepository.toString())
    }

    fun getNotifications() {
        Log.d("REPOSITORY", userDataRepository.toString())
        notificationLiveData.value = userDataRepository.unreadNotification
    }
}