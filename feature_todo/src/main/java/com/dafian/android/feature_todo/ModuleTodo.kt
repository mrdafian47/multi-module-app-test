package com.dafian.android.feature_todo

import com.dafian.android.feature_todo.data.RestServiceFactory
import com.dafian.android.feature_todo.repository.TodoRepository
import com.dafian.android.feature_todo.repository.TodoRepositoryImpl
import org.koin.dsl.module.module

val moduleTodo = module {

    single { RestServiceFactory.makeClientService(get(), get()) }

    single { RestServiceFactory.makeRestService(get(), get(), get()) }

    single<TodoRepository> { TodoRepositoryImpl(get()) }
}