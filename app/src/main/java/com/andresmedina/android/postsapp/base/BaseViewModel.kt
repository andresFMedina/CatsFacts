package com.andresmedina.android.postsapp.base

import androidx.lifecycle.ViewModel
import com.andresmedina.android.postsapp.di.component.DaggerViewModelInjector
import com.andresmedina.android.postsapp.di.component.ViewModelInjector
import com.andresmedina.android.postsapp.di.module.NetworkModule
import com.andresmedina.android.postsapp.viewmodel.posts.PostListViewModel
import com.andresmedina.android.postsapp.viewmodel.user.UserListViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is UserListViewModel -> injector.inject(this)
        }
    }
}