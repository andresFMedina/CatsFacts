package com.andresmedina.android.postsapp.di.module

import com.andresmedina.android.postsapp.network.PostApiService
import com.andresmedina.android.postsapp.network.URL_BASE
import com.andresmedina.android.postsapp.network.UserApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApiService(retrofit: Retrofit): PostApiService {
        return retrofit.create(PostApiService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}