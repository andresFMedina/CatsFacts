package com.andresmedina.android.postsapp.viewmodel.user

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmedina.android.postsapp.data.model.User
import com.andresmedina.android.postsapp.util.startPostActivity

class UserViewModel: ViewModel() {
    private lateinit var user: User

    val name: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val phone: MutableLiveData<String> = MutableLiveData()
    val website: MutableLiveData<String> = MutableLiveData()


    fun bind(user: User) {
        this.user = user
        name.value = user.name
        email.value = user.email
        phone.value = user.phone
        website.value = user.website
    }


    fun goToPostActivity(view: View) {
        view.context.startPostActivity(user)
    }
}