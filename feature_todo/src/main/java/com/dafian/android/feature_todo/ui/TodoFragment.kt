package com.dafian.android.feature_todo.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.common.base.BaseFragment
import com.dafian.android.common.util.NavigationFragment
import com.dafian.android.feature_todo.R
import com.dafian.android.feature_todo.entity.Todo
import kotlinx.android.synthetic.main.fragment_todo.*
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class TodoFragment : BaseFragment(),NavigationFragment {

    private val presenter by viewModel<TodoPresenter>()

    private val todoList = mutableListOf<Todo>()
    private val todoAdapter = TodoAdapter(todoList)

    companion object {

        fun newInstance(): TodoFragment {
            return TodoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
        loadingData()
    }

    override fun showError(throwable: Throwable) {
        Timber.e("Error Todo ${throwable.printStackTrace()}")
    }

    private fun initView() {

        with(rvTodo) {
            layoutManager = LinearLayoutManager(ctx)
            itemAnimator = DefaultItemAnimator()
            adapter = todoAdapter
        }
    }

    private fun initEvent() {

        swTodo.setOnRefreshListener {
            todoList.clear()
            todoAdapter.notifyDataSetChanged()
        }
    }

    private fun loadingData() {

        swTodo.isRefreshing = true

        presenter.getTodoAll()

        presenter.todoList.observe(this, Observer {
            it?.let { list ->
                this.todoList.addAll(list)
                this.todoAdapter.notifyDataSetChanged()
            }
        })

        presenter.error.observe(this, Observer {
            it?.let {error ->
                showError(error)
            }
        })
    }
}