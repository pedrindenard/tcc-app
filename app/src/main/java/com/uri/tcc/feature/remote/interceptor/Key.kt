package com.uri.tcc.feature.remote.interceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class Key(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val parameters = chain.request().url.newBuilder()
            .addQueryParameter(name = "Authorization", value = "Bearer ${context.filesDir}")
            .build()

        val newBuilder = chain.request().newBuilder().url(parameters)

        return chain.proceed(newBuilder.build())
    }
}