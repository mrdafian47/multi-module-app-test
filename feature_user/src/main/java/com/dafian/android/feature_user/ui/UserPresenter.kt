package com.dafian.android.feature_user.ui

import android.arch.lifecycle.MutableLiveData
import com.dafian.android.common.base.BasePresenter
import com.dafian.android.feature_user.entity.User
import com.dafian.android.feature_user.repository.UserRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserPresenter(
    private val repository: UserRepository,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter() {

    val error = MutableLiveData<Throwable>()
    val userList = MutableLiveData<List<User>>()

    fun getUserAll() {
        compositeDisposable.add(repository.getUserAll()
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                userList.postValue(it)
            }, {
                error.postValue(it)
            }))
    }
}