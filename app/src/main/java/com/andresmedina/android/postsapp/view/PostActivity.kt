package com.andresmedina.android.postsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.andresmedina.android.postsapp.R
import com.andresmedina.android.postsapp.data.model.User
import com.andresmedina.android.postsapp.databinding.ActivityPostBinding
import com.andresmedina.android.postsapp.viewmodel.post.PostListViewModel
import com.andresmedina.android.postsapp.viewmodel.user.UserViewModel

class PostActivity : AppCompatActivity() {

    private lateinit var postListViewModel: PostListViewModel
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityPostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_post)

        postListViewModel = ViewModelProvider(this).get(PostListViewModel::class.java)
        user = intent.extras?.getSerializable("user") as User

        val userViewModel = UserViewModel()

        binding.postListViewModel = postListViewModel
        binding.userViewModel = userViewModel

        userViewModel.bind(user)
        postListViewModel.getPosts(user.id)
    }
}