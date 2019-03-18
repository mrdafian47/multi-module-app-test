package com.dafian.android.feature_user.data

import com.dafian.android.feature_user.entity.User
import io.reactivex.Flowable
import retrofit2.http.GET

interface RestService {

    @GET("/users")
    fun getUserAll(): Flowable<List<User>>
}