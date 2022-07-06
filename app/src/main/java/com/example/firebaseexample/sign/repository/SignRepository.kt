package com.example.firebaseexample.sign.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

class SignRepository
{
    fun signInFirebase(email: String, password: String, signInResult: MutableLiveData<String?>)
    {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener()
        {
            if(it.isSuccessful)
            {
                signInResult.value = FirebaseAuth.getInstance().uid
                Log.d("*** signIn 성공 ***", "${it.result}")
            }
            else
            {
                signInResult.value = null
                Log.e("*** signIn 실패 ***", "${it.exception}")
            }
        }
    }
}