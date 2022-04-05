package com.example.retrofitmvvmhaberuygulamasi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmhaberuygulamasi.R
import com.example.retrofitmvvmhaberuygulamasi.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostListAdapter(val postList:ArrayList<Post>):RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {
    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){

    }
    fun updatePostList(newUpdatedPost:List<Post>){
        postList.clear()
        postList.addAll(newUpdatedPost)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.post_item,parent,false)
        return  PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemView.textView_id.text=postList.get(position).id.toString()
        holder.itemView.textView_title.text=postList.get(position).title
        holder.itemView.textView_body.text=postList.get(position).body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

