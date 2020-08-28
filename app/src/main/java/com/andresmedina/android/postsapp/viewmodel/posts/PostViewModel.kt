package com.andresmedina.android.postsapp.viewmodel.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmedina.android.postsapp.data.model.Post

class PostViewModel: ViewModel() {
    private val title: MutableLiveData<String> = MutableLiveData()
    private val body: MutableLiveData<String> = MutableLiveData()

    fun bind(post: Post) {
        title.value = post.title
        body.value = post.body
    }
}