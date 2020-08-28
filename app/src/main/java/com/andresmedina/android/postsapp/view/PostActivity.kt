package com.andresmedina.android.postsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.andresmedina.android.postsapp.R
import com.andresmedina.android.postsapp.databinding.ActivityPostBinding
import com.andresmedina.android.postsapp.viewmodel.post.PostListViewModel

class PostActivity : AppCompatActivity() {

    private lateinit var postListViewModel: PostListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_post)

        postListViewModel = ViewModelProvider(this).get(PostListViewModel::class.java)

        binding.postListViewModel = postListViewModel

        postListViewModel.getPosts(1)
    }
}