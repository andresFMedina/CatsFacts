package com.andresmedina.android.postsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.andresmedina.android.postsapp.R
import com.andresmedina.android.postsapp.databinding.ActivityMainBinding
import com.andresmedina.android.postsapp.viewmodel.user.UserListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userListViewModel: UserListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        binding.userListViewModel = userListViewModel

        userListViewModel.getUsers()
    }
}