package com.dafian.android.common

import com.dafian.android.common.network.NetworkServiceFactory
import com.dafian.android.common.util.helper.NetworkHelper
import org.koin.dsl.module.module

val moduleCommon = module {

    single { NetworkServiceFactory.makeLoggingInterceptor() }

    single { NetworkServiceFactory.makeObjectMapper() }

    single { NetworkServiceFactory.makeCache(get()) }

    single { NetworkHelper(get()) }
}