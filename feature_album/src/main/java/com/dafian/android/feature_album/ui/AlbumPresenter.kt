package com.dafian.android.feature_album.ui

import android.arch.lifecycle.MutableLiveData
import com.dafian.android.common.base.BasePresenter
import com.dafian.android.feature_album.entity.Album
import com.dafian.android.feature_album.repository.AlbumRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumPresenter(
    private val repository: AlbumRepository,
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread(),
    private val processScheduler: Scheduler = Schedulers.io()
) : BasePresenter() {

    val error = MutableLiveData<Throwable>()
    val albumModelList = MutableLiveData<List<Album>>()

    fun getAlbumAll() {
        compositeDisposable.add(repository.showAlbumAll()
            .observeOn(androidScheduler)
            .subscribeOn(processScheduler)
            .subscribe({
                albumModelList.postValue(it)
            }, {
                error.postValue(it)
            }))
    }
}