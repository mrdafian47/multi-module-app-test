package com.dafian.android.feature_todo.repository

import com.dafian.android.common.base.BaseRepository
import com.dafian.android.feature_todo.entity.Todo
import io.reactivex.Flowable

interface TodoRepository : BaseRepository {

    fun getTodoAll(): Flowable<List<Todo>>
}