package com.dafian.android.feature_todo.ui

import android.arch.lifecycle.MutableLiveData
import com.dafian.android.common.base.BasePresenter
import com.dafian.android.feature_todo.entity.Todo
import com.dafian.android.feature_todo.repository.TodoRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TodoPresenter(
    private val repository: TodoRepository,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter() {

    val error = MutableLiveData<Throwable>()
    val todoList = MutableLiveData<List<Todo>>()

    fun getTodoAll() {
        compositeDisposable.add(repository.getTodoAll()
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                todoList.postValue(it)
            }, {
                error.postValue(it)
            }))
    }
}