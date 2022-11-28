package com.uri.tcc.core.di

import com.uri.tcc.feature.remote.Retrofit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object Domain {

    val module = module {
        single {
            Retrofit.getStudentInstance(context = androidContext())
        }
        single {
            Retrofit.getTeacherInstance(context = androidContext())
        }
        single {
            Retrofit.getOrientationInstance(context = androidContext())
        }
        single {
            Retrofit.getTccInstance(context = androidContext())
        }
        single {
            Retrofit.getCourseInstance(context = androidContext())
        }
        single {
            Retrofit.getLibraryInstance(context = androidContext())
        }
    }
}