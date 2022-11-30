package com.uri.tcc.feature.data.remote.interceptor

import android.content.Context
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.domain.model.auth.LoginResponse
import com.uri.tcc.utils.Converters.fromJsonTo
import okhttp3.Interceptor
import okhttp3.Response

class Key(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request().newBuilder()

        SharedPreferencesImpl(context).apply {
            val result = get(SharedPreferencesImpl.Setting.USER_TOKEN).fromJsonTo<LoginResponse>()
            originalRequest.addHeader(name = "Authorization", value = "Bearer ${result?.token}")
        }

        val parameters = chain.request().url.newBuilder()
            .addQueryParameter("", "")
            .build()

        return chain.proceed(originalRequest.url(parameters).build())
    }
}