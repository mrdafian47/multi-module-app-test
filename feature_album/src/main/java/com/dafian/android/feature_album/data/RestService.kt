package com.dafian.android.feature_album.data

import com.dafian.android.feature_album.entity.Album
import io.reactivex.Flowable
import retrofit2.http.GET

interface RestService {

    @GET("/albums")
    fun showAlbumAll(): Flowable<List<Album>>
}