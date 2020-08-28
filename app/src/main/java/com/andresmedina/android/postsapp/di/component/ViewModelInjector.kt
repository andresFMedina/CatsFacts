package com.andresmedina.android.postsapp.di.component

import com.andresmedina.android.postsapp.di.module.NetworkModule
import com.andresmedina.android.postsapp.viewmodel.post.PostListViewModel
import com.andresmedina.android.postsapp.viewmodel.user.UserListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)
    fun inject(userListViewModel: UserListViewModel)

    @Component.Builder
    interface Builder{
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }


}