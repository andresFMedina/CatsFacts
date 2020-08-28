package com.andresmedina.android.postsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.andresmedina.android.postsapp.R
import com.andresmedina.android.postsapp.data.model.User
import com.andresmedina.android.postsapp.databinding.CardviewUserBinding
import com.andresmedina.android.postsapp.viewmodel.user.UserViewModel

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    private lateinit var users: List<User>

    class ViewHolder(
        private val binding: CardviewUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val userViewModel = UserViewModel()

        fun bind(user: User) {
            userViewModel.bind(user)
            binding.userViewModel = userViewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CardviewUserBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cardview_user,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::users.isInitialized) users.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    fun updateUsers(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }
}