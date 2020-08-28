package com.andresmedina.android.postsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.andresmedina.android.postsapp.R
import com.andresmedina.android.postsapp.data.model.Post
import com.andresmedina.android.postsapp.databinding.CardviewPostBinding
import com.andresmedina.android.postsapp.viewmodel.post.PostViewModel

class PostsListAdapter: RecyclerView.Adapter<PostsListAdapter.ViewHolder>() {
    lateinit var posts: List<Post>

    class ViewHolder(private val binding: CardviewPostBinding): RecyclerView.ViewHolder(binding.root){
        private val postViewModel = PostViewModel()

        fun bind(post: Post) {
            binding.postViewModel = postViewModel
            postViewModel.bind(post)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CardviewPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cardview_post,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::posts.isInitialized) posts.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    fun updatePosts(posts: List<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }
}