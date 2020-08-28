package com.andresmedina.android.postsapp.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.andresmedina.android.postsapp.data.model.User
import com.andresmedina.android.postsapp.view.PostActivity

const val USER_KEY = "user"

fun Context.startPostActivity(user: User) {
    Intent(this, PostActivity::class.java).also {
        val bundle = Bundle()
        bundle.putSerializable(USER_KEY, user)
        it.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        it.putExtras(bundle)
        startActivity(it)
    }
}