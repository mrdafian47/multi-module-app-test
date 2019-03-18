package com.dafian.android.feature_album.repository

import com.dafian.android.feature_album.data.RestService
import com.dafian.android.feature_album.entity.Album
import io.reactivex.Flowable

class AlbumRepositoryImpl(
    private val service: RestService
) : AlbumRepository {

    override fun showAlbumAll(): Flowable<List<Album>> {
        return service.showAlbumAll()
    }
}