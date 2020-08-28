package com.andresmedina.android.postsapp.network

import com.andresmedina.android.postsapp.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApiService {
    @GET(URL_BASE + USERS_ENDPOINT)
    fun getUsers(): Observable<List<User>>
}