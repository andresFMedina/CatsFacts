package com.andresmedina.android.postsapp.viewmodel.user

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.andresmedina.android.postsapp.base.BaseViewModel
import com.andresmedina.android.postsapp.data.model.User
import com.andresmedina.android.postsapp.network.UserApiService
import com.andresmedina.android.postsapp.view.adapter.UsersListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListViewModel : BaseViewModel() {
    @Inject
    lateinit var userApiService: UserApiService

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val usersListAdapter = UsersListAdapter()

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
        usersListAdapter.updateUsers(users)
    }

    private fun onFailureRequest(message: String) {
        Log.e("Error", message)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}