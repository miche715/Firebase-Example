package com.example.firebaseexample.user.domain

data class User(var documentId: String? = null,
                var email: String? = null,
                var name: String? = null,
                var nickName: String? = null,
                var pictureURL: String? = null,
)