package com.andresmedina.android.postsapp.data.model

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String

):Serializable

