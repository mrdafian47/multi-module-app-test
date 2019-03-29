package com.dafian.android.feature_todo

import com.dafian.android.feature_todo.data.RestServiceFactory
import com.dafian.android.feature_todo.repository.TodoRepository
import com.dafian.android.feature_todo.repository.TodoRepositoryImpl
import com.dafian.android.feature_todo.ui.TodoPresenter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val moduleTodo = module {

    single(name = "todo_client") { RestServiceFactory.makeClientService(get(), get()) }

    single { RestServiceFactory.makeRestService(get(), get(name = "todo_client"), get()) }

    single<TodoRepository> { TodoRepositoryImpl(get()) }

    viewModel { TodoPresenter(get()) }
}