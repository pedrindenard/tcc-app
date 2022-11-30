package com.uri.tcc.feature.data.remote

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uri.tcc.BuildConfig
import com.uri.tcc.feature.data.remote.interceptor.Key
import com.uri.tcc.feature.data.remote.interceptor.Logger
import com.uri.tcc.feature.data.remote.network.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {

    companion object {

        private const val BASE_URL = "http://10.0.2.2:3333/"

        private val logger: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor(Logger()).apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

        private val Context.client: OkHttpClient
            get() = OkHttpClient.Builder()
                .connectTimeout(timeout = 60, TimeUnit.SECONDS)
                .readTimeout(timeout = 60, TimeUnit.SECONDS)
                .addInterceptor(Key(context = this))
                .addInterceptor(logger)
                .build()

        private val Context.getRetrofitInstance: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()

        fun getStudentInstance(context: Context): Api {
            return context.getRetrofitInstance.create(Api::class.java)
        }
    }
}