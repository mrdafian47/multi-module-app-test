package com.dafian.android.feature_album.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dafian.android.feature_album.R
import com.dafian.android.feature_album.entity.Album
import kotlinx.android.synthetic.main.row_album.view.*
import org.jetbrains.anko.toast

class AlbumAdapter(
    private val albumList: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {

    override fun getItemCount(): Int = albumList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_album, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.bind(albumList[position])
    }

    class AlbumHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(album: Album) {
            with(itemView) {
                tvAlbumName.text = album.title
                setOnClickListener {
                    context.toast("Album ${album.title}")
                }
            }
        }
    }
}