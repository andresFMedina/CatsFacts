package com.andresmedina.android.postsapp.viewmodel.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmedina.android.postsapp.data.model.User

class UserViewModel: ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val phone: MutableLiveData<String> = MutableLiveData()
    val website: MutableLiveData<String> = MutableLiveData()

    fun bind(user: User) {
        name.value = user.name
        email.value = user.email
        phone.value = user.phone
        website.value = user.website
    }
}