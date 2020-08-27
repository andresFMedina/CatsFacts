package com.andresmedina.android.catsfacts.viewmodel.user

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.andresmedina.android.catsfacts.base.BaseViewModel
import com.andresmedina.android.catsfacts.data.model.User
import com.andresmedina.android.catsfacts.network.UserApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListViewModel : BaseViewModel() {
    @Inject
    private lateinit var userApiService: UserApiService

    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    private lateinit var subscription: Disposable

    fun getUsers() {
        subscription = userApiService.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStartRequest() }
            .subscribe(
                { users ->
                    onSuccessRequest(users)
                    onFinishRequest()
                },
                { error ->
                    onFailureRequest(error.message!!)
                    onFinishRequest()
                })
    }

    private fun onStartRequest() {
        loadingVisibility.postValue(View.VISIBLE)
    }

    private fun onFinishRequest() {
        loadingVisibility.postValue(View.GONE)
    }

    private fun onSuccessRequest(users: List<User>) {

    }

    private fun onFailureRequest(message: String) {

    }
}