package com.andresmedina.android.postsapp.databinding

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

object ViewExtensions {
    @JvmStatic
    fun getParentActivity(view: View): AppCompatActivity? {
        var context = view.context
        while (context is ContextWrapper) {
            if (context is AppCompatActivity) {
                return context as AppCompatActivity
            }
            context = context.baseContext
        }
        return null
    }
}
