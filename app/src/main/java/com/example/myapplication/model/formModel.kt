package com.example.myapplication.model

data class formModel(
    val firstName:String?=null,
    val lastName:String?=null,
    val gender:String?=null,
    val email:String?=null,
    val phone:String?=null,
    val partnerName: String? = null,
    val partnerDob: String? = null,
    val address: String? = null,
    val occupation: String? = null,
    val isSingle: Boolean = false,
    val isMarried: Boolean = false,
    val isDivorced: Boolean = false
)
