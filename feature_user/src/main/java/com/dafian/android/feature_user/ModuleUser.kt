package com.dafian.android.feature_user

import com.dafian.android.feature_user.data.RestServiceFactory
import com.dafian.android.feature_user.repository.UserRepository
import com.dafian.android.feature_user.repository.UserRepositoryImpl
import com.dafian.android.feature_user.ui.UserPresenter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val moduleUser = module("com.dafian.android.feature_todo", override = true) {

    single("com.dafian.android.feature_todo") { RestServiceFactory.makeClientService(get(), get()) }

    single { RestServiceFactory.makeRestService(get(), getProperty("com.dafian.android.feature_todo"), get()) }

    single<UserRepository> { UserRepositoryImpl(get()) }

    viewModel { UserPresenter(get()) }
}