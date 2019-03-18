package com.dafian.android.feature_user.repository

import com.dafian.android.feature_user.data.RestService
import com.dafian.android.feature_user.entity.User
import io.reactivex.Flowable

class UserRepositoryImpl(
    private val service: RestService
) : UserRepository {

    override fun getUserAll(): Flowable<List<User>> {
        return service.getUserAll()
    }
}