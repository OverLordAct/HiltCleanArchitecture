package com.joydeep.hiltcleanarchitecture.employee.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joydeep.domain.common.usecase.BaseUseCase
import com.joydeep.domain.login.entity.UserResponse
import com.joydeep.domain.login.entity.UsersResponse
import com.joydeep.domain.login.usecase.GetAllUsersUseCase
import com.joydeep.domain.login.usecase.GetUserUseCase
import kotlinx.coroutines.launch

class EmployeeActivityViewModel @ViewModelInject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    var userStatusLiveData = MutableLiveData<UserStatus<List<UsersResponse.User>>>()

    private val allUsersUseCaseCallback = object : BaseUseCase.Callback<UsersResponse> {
        override fun onSuccess(result: UsersResponse) {
            userStatusLiveData.value = UserStatus.Success(result.data)
        }

        override fun onError(throwable: Throwable) {
            userStatusLiveData.value = UserStatus.Failure(throwable.toString())
        }
    }

    private val userUseCaseCallback = object : BaseUseCase.Callback<UserResponse> {
        override fun onSuccess(result: UserResponse) {
            val userList = listOf(result.data)
            userStatusLiveData.value = UserStatus.Success(userList)
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