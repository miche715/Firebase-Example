package com.example.firebaseexample.sign.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class SignRepository @Inject constructor()
{
    fun signInFirebase(email: String, password: String, _signInResult: MutableLiveData<String?>)
    {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener()
        {
            if(it.isSuccessful)
            {
                _signInResult.value = FirebaseAuth.getInstance().uid
                Log.d("*** signIn 성공 ***", "${it.result}")
            }
            else
            {
                _signInResult.value = null
                Log.e("*** signIn 실패 ***", "${it.exception}")
            }
        }
    }

    fun signUpFirebase(email: String, password: String, _signUpResult: MutableLiveData<String?>)
    {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener()
        {
            if(it.isSuccessful)
            {
                _signUpResult.value = FirebaseAuth.getInstance().uid
                Log.d("*** signUp 성공 ***", "${it.result}")
            }
            else
            {
                _signUpResult.value = null
                Log.e("*** signUp 실패 ***", "${it.exception}")
            }
        }
    }
}