package com.andresmedina.android.catsfacts.network

import com.andresmedina.android.catsfacts.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApiService {

    @GET(URL_BASE + USERS_ENDPOINT)
    fun getUsers(): Observable<List<User>>
}