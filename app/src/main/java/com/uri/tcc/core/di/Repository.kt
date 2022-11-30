package com.uri.tcc.core.di

import com.uri.tcc.feature.data.repository.ClassAllRepository
import com.uri.tcc.feature.data.repository.MessageRepository
import com.uri.tcc.feature.data.repository.TccRepository
import com.uri.tcc.feature.data.repository.UserRepository
import org.koin.dsl.module

object Repository {

    val module = module(override = true) {
        single {
            UserRepository(api = get(), sharedPreferences = get())
        }
        single {
            MessageRepository(api = get(), sharedPreferences = get())
        }
        single {
            TccRepository(api = get())
        }
        single {
            ClassAllRepository(api = get())
        }
    }
}