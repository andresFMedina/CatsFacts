package com.andresmedina.android.catsfacts.viewmodel.posts

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.andresmedina.android.catsfacts.base.BaseViewModel
import com.andresmedina.android.catsfacts.data.model.Post
import com.andresmedina.android.catsfacts.network.PostApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel : BaseViewModel() {

    @Inject
    lateinit var postApiService: PostApiService

    private val loadingVisibility = MutableLiveData<Int>()

    private lateinit var subscription: Disposable

    fun getPosts(userId: Int) {
        subscription = postApiService.getPostsByUserId(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStartRequest() }
            .subscribe(
                { result ->
                    onSuccessRequest(result)
                    onFinishRequest()

                },
                { error ->
                    onFailureRequest(error.message.toString())
                    onFinishRequest()
                })
    }

    private fun onStartRequest() {
        loadingVisibility.postValue(View.VISIBLE)
    }

    private fun onFinishRequest() {
        loadingVisibility.postValue(View.GONE)
    }

    private fun onSuccessRequest(posts: List<Post>) {

    }

    private fun onFailureRequest(message: String) {

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose();
    }
}