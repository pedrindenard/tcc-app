package com.uri.tcc

import android.app.Application
import com.uri.tcc.core.di.Domain
import com.uri.tcc.core.di.Repository
import com.uri.tcc.core.di.UseCase
import com.uri.tcc.core.di.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setKoin()
    }

    private fun setKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)

            val modules = listOf(
                Domain.module,
                Repository.module,
                UseCase.module,
                ViewModel.module
            )

            koin.loadModules(modules)
        }
    }
}