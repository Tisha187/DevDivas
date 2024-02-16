package com.example.myapplication.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(
    val name: String ?= null,
    val email: String?=null,
    val password:String?=null

)
