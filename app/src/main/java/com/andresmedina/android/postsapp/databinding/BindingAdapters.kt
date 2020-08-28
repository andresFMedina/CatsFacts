package com.andresmedina.android.postsapp.databinding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

object BindingAdapters {

    @BindingAdapter("mutableVisibility")
    @JvmStatic
    fun setMutableVisibility(
        view: View,
        visibility: MutableLiveData<Int>
    ) {
        val parentActivity: AppCompatActivity? = ViewExtensions.getParentActivity(view)
        if (parentActivity != null) {
            visibility.observe(parentActivity, object : Observer<Int?> {
                override fun onChanged( integer: Int?) {
                    val value = integer ?: View.GONE
                    view.visibility = value
                }
            })
        }
    }
}