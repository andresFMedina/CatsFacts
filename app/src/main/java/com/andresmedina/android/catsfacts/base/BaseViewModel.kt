package com.andresmedina.android.catsfacts.base

import androidx.lifecycle.ViewModel
import com.andresmedina.android.catsfacts.di.component.DaggerViewModelInjector
import com.andresmedina.android.catsfacts.di.component.ViewModelInjector
import com.andresmedina.android.catsfacts.di.module.NetworkModule
import com.andresmedina.android.catsfacts.viewmodel.posts.PostListViewModel
import com.andresmedina.android.catsfacts.viewmodel.user.UserListViewModel

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