package com.dafian.android.feature_todo

import com.dafian.android.feature_todo.data.RestServiceFactory
import com.dafian.android.feature_todo.repository.TodoRepository
import com.dafian.android.feature_todo.repository.TodoRepositoryImpl
import org.koin.dsl.module.module

val moduleTodo = module("com.dafian.android.feature_todo", override = true) {

    single("com.dafian.android.feature_todo") { RestServiceFactory.makeClientService(get(), get()) }

    single { RestServiceFactory.makeRestService(get(), getProperty("com.dafian.android.feature_todo"), get()) }

    single<TodoRepository> { TodoRepositoryImpl(get()) }
}