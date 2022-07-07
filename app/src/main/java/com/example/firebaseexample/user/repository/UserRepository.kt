package com.example.firebaseexample.user.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firebaseexample.user.domain.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class UserRepository @Inject constructor()
{
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val firebaseDatabase = FirebaseFirestore.getInstance()

    fun createUserFirebase(name: String, nickName: String, _createUserResult: MutableLiveData<User?>)
    {
        val newUser: MutableMap<String, Any> = mutableMapOf("email" to firebaseAuth.currentUser!!.email!!,
                                                            "name" to name,
                                                            "nick_name" to nickName)

        firebaseDatabase.collection("user").whereEqualTo("nick_name", nickName).get().addOnCompleteListener()
        {
            if(it.result.size() == 0)
            {
                firebaseDatabase.collection("user").add(newUser).addOnCompleteListener()
                {
                    if(it.isSuccessful)
                    {
                        _createUserResult.value = User().apply()
                        {
                            this.documentId = it.result.id
                            this.email = newUser["email"] as String
                            this.name = newUser["name"] as String
                            this.nickName = newUser["nick_name"] as String
                        }
                        Log.d("*** createUser 성공 ***", "${it.result}")
                    }
                    else
                    {
                        _createUserResult.value = null
                        Log.e("*** createUser 실패 ***", "${it.exception}")
                    }
                }
            }
            else
            {
                _createUserResult.value = null
                Log.e("*** createUser 실패 ***", "duplicate nickname")
            }
        }
    }




}