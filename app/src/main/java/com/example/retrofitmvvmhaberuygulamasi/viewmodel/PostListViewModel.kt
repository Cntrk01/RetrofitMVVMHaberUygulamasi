package com.example.retrofitmvvmhaberuygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmhaberuygulamasi.dataApi.PostService
import com.example.retrofitmvvmhaberuygulamasi.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostListViewModel:ViewModel() {
    val posts=MutableLiveData<List<Post>>()

    private val postService=PostService()
    private val disposable = CompositeDisposable()

    fun refresh(){
        fetchDataFromRemoteApi()
    }
    fun fetchDataFromRemoteApi(){
        disposable.add(
            postService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Post>>(){
                    override fun onSuccess(t: List<Post>) {
                        posts.value=t
                    }

                    override fun onError(e: Throwable) {
                         e.printStackTrace()
                    }

                })


        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}