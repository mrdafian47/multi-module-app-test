package com.dafian.android.feature_album.data

import android.content.Context
import com.dafian.android.feature_album.R
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

object RestServiceFactory {

    fun makeRestService(context: Context, client: OkHttpClient, mapper: ObjectMapper): RestService {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(client)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(RestService::class.java)
    }

    fun makeClientService(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                val ongoing = chain.request().newBuilder()
                ongoing.addHeader("Content-Type", "application/json")
                chain.proceed(ongoing.build())
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }
}