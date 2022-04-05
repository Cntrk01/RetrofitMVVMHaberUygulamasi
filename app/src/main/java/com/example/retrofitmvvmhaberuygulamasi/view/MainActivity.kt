package com.example.retrofitmvvmhaberuygulamasi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmvvmhaberuygulamasi.R
import com.example.retrofitmvvmhaberuygulamasi.databinding.ActivityMainBinding
import com.example.retrofitmvvmhaberuygulamasi.viewmodel.PostListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel:PostListViewModel
    private  var postListAdapter= PostListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get(PostListViewModel::class.java)
        viewModel.refresh()
        postList.layoutManager=LinearLayoutManager(this)
        postList.adapter=postListAdapter
        observeViewModel()
    }
    private fun observeViewModel(){
         viewModel.posts.observe(this, Observer {
             it?.let {
                 postListAdapter.updatePostList(it)
             }
         })
    }
}