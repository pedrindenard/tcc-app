package com.uri.tcc.feature.remote

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uri.tcc.BuildConfig
import com.uri.tcc.feature.remote.interceptor.Key
import com.uri.tcc.feature.remote.interceptor.Logger
import com.uri.tcc.feature.remote.network.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retrofit {

    companion object {

        private val logger: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor(Logger()).apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.NONE
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

        private val Context.client: OkHttpClient
            get() = OkHttpClient.Builder()
                .connectTimeout(timeout = 60, TimeUnit.SECONDS)
                .readTimeout(timeout = 60, TimeUnit.SECONDS)
                .addInterceptor(Key(this))
                .addInterceptor(logger)
                .build()

        private fun getRetrofitInstance(context: Context): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(context.client)
                .build()
        }

        fun getStudentInstance(context: Context): StudentApi {
            return getRetrofitInstance(context).create(StudentApi::class.java)
        }

        fun getTeacherInstance(context: Context): TeacherApi {
            return getRetrofitInstance(context).create(TeacherApi::class.java)
        }

        fun getTccInstance(context: Context): TccApi {
            return getRetrofitInstance(context).create(TccApi::class.java)
        }

        fun getOrientationInstance(context: Context): OrientationApi {
            return getRetrofitInstance(context).create(OrientationApi::class.java)
        }

        fun getLibraryInstance(context: Context): LibraryApi {
            return getRetrofitInstance(context).create(LibraryApi::class.java)
        }

        fun getCourseInstance(context: Context): CourseApi {
            return getRetrofitInstance(context).create(CourseApi::class.java)
        }
    }
}