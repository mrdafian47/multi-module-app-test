package com.dafian.android.feature_todo.data

import com.dafian.android.feature_todo.entity.Todo
import io.reactivex.Flowable
import retrofit2.http.GET

interface RestService {

    @GET("/todos")
    fun getTodoAll() : Flowable<List<Todo>>
}