package com.example.retrofitmvvmhaberuygulamasi.dataApi

import com.example.retrofitmvvmhaberuygulamasi.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}