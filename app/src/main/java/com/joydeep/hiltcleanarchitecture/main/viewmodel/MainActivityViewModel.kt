package com.joydeep.hiltcleanarchitecture.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joydeep.domain.entity.Users
import com.joydeep.domain.usecase.BaseUseCase
import com.joydeep.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    var usersStatusLiveData = MutableLiveData<UserStatus<Users>>()

    private val usersUserCaseCallback = object: BaseUseCase.Callback<Users> {
        override fun onSuccess(result: Users) {
            usersStatusLiveData.value = UserStatus.Success(result)
        }

        override fun onError(throwable: Throwable) {
            usersStatusLiveData.value = UserStatus.Failure(throwable.toString())
        }
    }

    fun getUsers(page: Int) {
        viewModelScope.launch {
            getUsersUseCase.execute(page, usersUserCaseCallback)
        }
    }
}