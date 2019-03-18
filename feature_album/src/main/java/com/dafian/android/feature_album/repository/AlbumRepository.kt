package com.dafian.android.feature_album.repository

import com.dafian.android.common.base.BaseRepository
import com.dafian.android.feature_album.entity.Album
import io.reactivex.Flowable

interface AlbumRepository : BaseRepository {

    fun showAlbumAll() : Flowable<List<Album>>
}