package com.joydeep.hiltcleanarchitecture.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.joydeep.domain.entity.Users
import com.joydeep.hiltcleanarchitecture.databinding.ActivityMainBinding
import com.joydeep.hiltcleanarchitecture.main.viewmodel.MainActivityViewModel
import com.joydeep.hiltcleanarchitecture.main.viewmodel.UserStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.usersStatusLiveData.observe(this, ::userStatusUpdate)

        binding.submitButton.setOnClickListener {
            val page = binding.userIdInput.text.toString().toInt()

            viewModel.getUsers(page)
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