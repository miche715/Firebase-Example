package com.example.firebaseexample.sign.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firebaseexample.databinding.ActivitySignInBinding
import com.example.firebaseexample.sign.viewmodel.SignViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

            if(binding.emailTextInputEditText.text!!.isEmpty()) { binding.emailTextInputLayout.error = "이메일을 입력해 주세요." }
            else { binding.emailTextInputLayout.error = null }

            if(binding.passwordTextInputEditText.text!!.isEmpty()) { binding.passwordTextInputLayout.error = "패스워드를 입력해 주세요." }
            else { binding.passwordTextInputLayout.error = null }

        }
        signViewModel.signInResult.observe(this)
        {
            if(it != null)  // 로그인 성공
            {

            }
            else  // 로그인 실패
            {
                Snackbar.make(binding.mainLayout, "이메일 또는 패스워드가 잘못됐습니다.", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener()
        {
            Intent(this@SignInActivity, SignUpActivity::class.java).run()
            {
                startActivity(this)
            }
        }


    }
}