package com.example.firebaseexample.sign.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firebaseexample.databinding.ActivitySignUpBinding
import com.example.firebaseexample.sign.viewmodel.SignViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignUpBinding

    private val signViewModel: SignViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener()
        {
            if(binding.emailTextInputEditText.text!!.isNotEmpty() && binding.passwordTextInputEditText.text!!.isNotEmpty())
            {
                signViewModel.signUp(binding.emailTextInputEditText.text.toString(), binding.passwordTextInputEditText.text.toString())
            }

            if(binding.emailTextInputEditText.text!!.isEmpty()) { binding.emailTextInputLayout.error = "이메일을 입력해 주세요." }
            else { binding.emailTextInputLayout.error = null }

            if(binding.passwordTextInputEditText.text!!.isEmpty()) { binding.passwordTextInputLayout.error = "패스워드를 입력해 주세요." }
            else { binding.passwordTextInputLayout.error = null }

        }
        signViewModel.signUpResult.observe(this)
        {
            if(it != null)  // 회원가입 성공
            {

            }
            else  // 회원가입 실패
            {
                Snackbar.make(binding.mainLayout, "이미 가입된 이메일입니다.", Snackbar.LENGTH_SHORT).show()
            }
        }


    }
}