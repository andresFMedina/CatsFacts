package com.andresmedina.android.catsfacts.base

import androidx.lifecycle.ViewModel
import com.andresmedina.android.catsfacts.di.component.DaggerViewModelInjector
import com.andresmedina.android.catsfacts.di.component.ViewModelInjector
import com.andresmedina.android.catsfacts.di.module.NetworkModule
import com.andresmedina.android.catsfacts.viewmodel.posts.PostViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this) {
            is PostViewModel -> injector.inject(this)
        }
    }
}