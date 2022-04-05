package com.example.retrofitmvvmhaberuygulamasi.dataApi

import com.example.retrofitmvvmhaberuygulamasi.model.Post
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class PostService {
    private val BASE_URL="https://jsonplaceholder.typicode.com"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PostAPI::class.java)

    fun getPosts():Single<List<Post>>{
        return api.getPosts()
    }
}