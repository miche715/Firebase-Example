package com.example.firebaseexample.user.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firebaseexample.databinding.ActivityUserDetailBinding
import com.example.firebaseexample.user.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUserDetailBinding

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createUserButton.setOnClickListener()
        {
            userViewModel.createUser(binding.nameTextInputEditText.text.toString(), binding.nickNameTextInputEditText.text.toString())
        }
        userViewModel.createUserResult.observe(this)
        {
            println(it)
        }
    }
}