package com.dafian.android.feature_user.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.common.base.BaseFragment
import com.dafian.android.common.util.NavigationFragment
import com.dafian.android.feature_user.R
import com.dafian.android.feature_user.entity.User
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class UserFragment : BaseFragment(), NavigationFragment {

    private val presenter by viewModel<UserPresenter>()

    private val userList = mutableListOf<User>()
    private val userAdapter = UserAdapter(userList)

    companion object {

        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
        loadingData()
    }

    override fun showError(throwable: Throwable) {
        Timber.e("Error User ${throwable.printStackTrace()}")
    }

    private fun initView() {

        with(rvUser) {
            layoutManager = LinearLayoutManager(ctx)
            itemAnimator = DefaultItemAnimator()
            adapter = userAdapter
        }
    }

    private fun initEvent() {

        swUser.setOnRefreshListener {
            userList.clear()
            userAdapter.notifyDataSetChanged()
            loadingData()
        }
    }

    private fun loadingData() {

        swUser.isRefreshing = true
        presenter.getUserAll()

        presenter.userList.observe(this, Observer {
            it?.let { list ->
                this.userList.addAll(list)
                this.userAdapter.notifyDataSetChanged()
                swUser.isRefreshing = false
            }
        })

        presenter.error.observe(this, Observer {
            it?.let { error ->
                showError(error)
                swUser.isRefreshing = false
            }
        })
    }
}