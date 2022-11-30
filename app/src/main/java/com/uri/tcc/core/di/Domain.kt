package com.uri.tcc.core.di

import com.uri.tcc.feature.data.local.SharedPreferences
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.data.remote.Retrofit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object Domain {

    val module = module {
        single {
            Retrofit.getStudentInstance(context = androidContext())
        }
        single<SharedPreferences> {
            SharedPreferencesImpl(context = androidContext())
        }
    }
}