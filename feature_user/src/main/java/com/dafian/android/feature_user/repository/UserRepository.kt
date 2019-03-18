package com.dafian.android.feature_user.repository

import com.dafian.android.common.base.BaseRepository
import com.dafian.android.feature_user.entity.User
import io.reactivex.Flowable

interface UserRepository : BaseRepository {

    fun getUserAll(): Flowable<List<User>>
}