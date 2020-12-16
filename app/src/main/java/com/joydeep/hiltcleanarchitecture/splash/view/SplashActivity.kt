package com.joydeep.hiltcleanarchitecture.splash.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.joydeep.hiltcleanarchitecture.dashboard.view.DashboardActivity
import com.joydeep.hiltcleanarchitecture.databinding.ActivitySplashBinding
import com.joydeep.hiltcleanarchitecture.login.view.LoginActivity
import com.joydeep.hiltcleanarchitecture.splash.viewmodel.SplashActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashActivityViewModel by viewModels()
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loginStatusLiveData.observe(this) {
            when (it) {
                true -> {
                    startActivity(Intent(this, DashboardActivity::class.java))
                }
                false -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
            finish()
        }
    }
}