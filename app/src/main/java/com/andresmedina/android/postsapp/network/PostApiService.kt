package com.andresmedina.android.postsapp.network

import com.andresmedina.android.postsapp.data.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

const val USER_ID = "userId"

interface PostApiService {

    @GET(URL_BASE + POSTS_ENDPOINT)
    fun getPostsByUserId(@Query(USER_ID) userId: Int): Observable<List<Post>>

}
