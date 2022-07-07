package com.example.firebaseexample.sign.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseexample.sign.repository.SignRepository

class SignViewModel(private val signRepository: SignRepository = SignRepository()) : ViewModel()
{
    private val _signInResult: MutableLiveData<String?> = MutableLiveData()
    val signInResult: LiveData<String?> = _signInResult

    fun signIn(email: String, password: String)
    {
        signRepository.signInFirebase(email, password, _signInResult)
    }
}