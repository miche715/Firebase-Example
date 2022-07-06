package com.example.firebaseexample.sign.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firebaseexample.databinding.ActivitySignInBinding
import com.example.firebaseexample.sign.viewmodel.SignViewModel

class SignInActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignInBinding

    private val signViewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener()
        {
            if(binding.emailTextInputEditText.text!!.isNotEmpty() && binding.passwordTextInputEditText.text!!.isNotEmpty())
            {
                signViewModel.signIn(binding.emailTextInputEditText.text.toString(), binding.passwordTextInputEditText.text.toString())
            }
        }
        signViewModel.signInResult.observe(this)
        {
            if(it != null)  // 로그인 성공
            {

            }
            else  // 로그인 실패
            {

            }
        }




    }
}