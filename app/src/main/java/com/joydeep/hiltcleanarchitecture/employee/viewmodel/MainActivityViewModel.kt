package com.joydeep.hiltcleanarchitecture.employee.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joydeep.domain.common.usecase.BaseUseCase
import com.joydeep.domain.login.entity.Users
import com.joydeep.domain.login.usecase.GetAllUsersUseCase
import com.joydeep.domain.login.usecase.GetUserUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    var allUsersStatusLiveData = MutableLiveData<UserStatus<Users>>()
    var userStatusLiveData = MutableLiveData<UserStatus<Users.User>>()

    private val allUsersUseCaseCallback = object : BaseUseCase.Callback<Users> {
        override fun onSuccess(result: Users) {
            allUsersStatusLiveData.value = UserStatus.Success(result)
        }

        override fun onError(throwable: Throwable) {
            allUsersStatusLiveData.value = UserStatus.Failure(throwable.toString())
        }
    }

    private val userUseCaseCallback = object : BaseUseCase.Callback<Users.User> {
        override fun onSuccess(result: Users.User) {
            userStatusLiveData.value = UserStatus.Success(result)
        }

        override fun onError(throwable: Throwable) {
            userStatusLiveData.value = UserStatus.Failure(throwable.toString())
        }

    }

    fun getAllUsers(page: Int) {
        viewModelScope.launch {
            getAllUsersUseCase.execute(page, allUsersUseCaseCallback)
        }
    }

    fun getUser(id: Int) {
        viewModelScope.launch {
            getUserUseCase.execute(id, userUseCaseCallback)
        }
    }
}