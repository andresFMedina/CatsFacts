package com.andresmedina.android.postsapp.viewmodel.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmedina.android.postsapp.data.model.Post

class PostViewModel: ViewModel() {
    val title: MutableLiveData<String> = MutableLiveData()
    val body: MutableLiveData<String> = MutableLiveData()

    fun bind(post: Post) {
        title.value = post.title
        body.value = post.body
    }
}