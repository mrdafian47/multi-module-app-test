package com.dafian.android.feature_album

import com.dafian.android.feature_album.data.RestServiceFactory
import com.dafian.android.feature_album.repository.AlbumRepository
import com.dafian.android.feature_album.repository.AlbumRepositoryImpl
import com.dafian.android.feature_album.ui.AlbumPresenter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val moduleAlbum = module {

    single(name = "album_client") { RestServiceFactory.makeClientService(get(), get()) }

    single { RestServiceFactory.makeRestService(get(), get(name = "album_client"), get()) }

    single<AlbumRepository> { AlbumRepositoryImpl(get()) }

    viewModel { AlbumPresenter(get()) }
}