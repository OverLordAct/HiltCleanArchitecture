package com.joydeep.hiltcleanarchitecture.employee.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.joydeep.domain.login.entity.Users
import com.joydeep.hiltcleanarchitecture.databinding.ActivityEmployeeBinding
import com.joydeep.hiltcleanarchitecture.employee.viewmodel.MainActivityViewModel
import com.joydeep.hiltcleanarchitecture.employee.viewmodel.UserStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityEmployeeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.allUsersStatusLiveData.observe(this, ::userStatusUpdate)

        binding.getAllButton.setOnClickListener {
            viewModel.getAllUsers(1)
        }

        binding.getUserButton.setOnClickListener {

        }
    }

    private fun userStatusUpdate(result: UserStatus<Users>) {
        when (result) {
            is UserStatus.Loading -> {
                binding.progress.visibility = View.VISIBLE
            }
            is UserStatus.Success -> {
                binding.progress.visibility = View.GONE
                val usersList = result.data

                binding.result.text = usersList.toString()
            }

            is UserStatus.Failure -> {
                binding.progress.visibility = View.GONE
                Toast.makeText(this, "Error: ${result.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}