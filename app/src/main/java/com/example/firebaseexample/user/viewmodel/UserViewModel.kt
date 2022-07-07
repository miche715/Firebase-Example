package com.example.firebaseexample.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseexample.user.domain.User
import com.example.firebaseexample.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel()
{
    private val _createUserResult: MutableLiveData<User?> = MutableLiveData()
    val createUserResult: LiveData<User?> = _createUserResult

    fun createUser(name: String, nickName: String)
    {
        userRepository.createUserFirebase(name, nickName, _createUserResult)
    }
}