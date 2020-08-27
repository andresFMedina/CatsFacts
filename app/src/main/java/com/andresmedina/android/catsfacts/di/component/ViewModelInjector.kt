package com.andresmedina.android.catsfacts.di.component

import com.andresmedina.android.catsfacts.di.module.NetworkModule
import com.andresmedina.android.catsfacts.viewmodel.posts.PostListViewModel
import com.andresmedina.android.catsfacts.viewmodel.user.UserListViewModel
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