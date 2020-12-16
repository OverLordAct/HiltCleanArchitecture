package com.joydeep.hiltcleanarchitecture.account.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.joydeep.hiltcleanarchitecture.account.viewmodel.AccountActivityViewModel
import com.joydeep.hiltcleanarchitecture.databinding.ActivityAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountActivity : AppCompatActivity() {

    private val viewModel: AccountActivityViewModel by viewModels()
    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refreshButton.setOnClickListener {
            viewModel.refreshNotification()
        }

        binding.logoutButton.setOnClickListener {
            viewModel.logout()
            finish()
        }
    }
}