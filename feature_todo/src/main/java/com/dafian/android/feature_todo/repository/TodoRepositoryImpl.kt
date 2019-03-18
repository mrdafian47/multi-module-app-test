package com.dafian.android.feature_todo.repository

import com.dafian.android.feature_todo.data.RestService
import com.dafian.android.feature_todo.entity.Todo
import io.reactivex.Flowable

class TodoRepositoryImpl(
    private val service: RestService
) : TodoRepository {

    override fun getTodoAll(): Flowable<List<Todo>> {
        return service.getTodoAll()
    }
}