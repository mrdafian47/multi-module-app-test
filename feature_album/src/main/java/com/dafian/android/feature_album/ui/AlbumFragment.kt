package com.dafian.android.feature_album.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.common.base.BaseFragment
import com.dafian.android.common.util.NavigationFragment
import com.dafian.android.feature_album.R
import com.dafian.android.feature_album.entity.Album
import kotlinx.android.synthetic.main.fragment_album.*
import org.jetbrains.anko.support.v4.ctx
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class AlbumFragment : BaseFragment(), NavigationFragment {

    private val presenter by viewModel<AlbumPresenter>()

    private val albumList = mutableListOf<Album>()
    private val albumAdapter = AlbumAdapter(albumList)

    companion object {

        fun newInstance(): AlbumFragment {
            return AlbumFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
        loadingData()
    }

    override fun showError(throwable: Throwable) {
        Timber.e("Error Album ${throwable.printStackTrace()}")
    }

    private fun initView() {

        with(rvAlbum) {
            layoutManager = LinearLayoutManager(ctx)
            itemAnimator = DefaultItemAnimator()
            adapter = albumAdapter
        }
    }

    private fun initEvent() {

        swAlbum.setOnRefreshListener {
            albumList.clear()
            albumAdapter.notifyDataSetChanged()
            loadingData()
        }
    }

    private fun loadingData() {

        swAlbum.isRefreshing = true

        presenter.getAlbumAll()

        presenter.albumModelList.observe(this, Observer {
            it?.let { list ->
                this.albumList.addAll(list)
                this.albumAdapter.notifyDataSetChanged()
                swAlbum.isRefreshing = false
            }
        })

        presenter.error.observe(this, Observer {
            it?.let { error ->
                showError(error)
                swAlbum.isRefreshing = false
            }
        })
    }
}