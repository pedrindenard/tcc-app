package com.uri.tcc.core.di

import com.uri.tcc.feature.repository.LibraryRepository
import com.uri.tcc.feature.repository.NotificationRepository
import com.uri.tcc.feature.repository.TccRepository
import com.uri.tcc.feature.repository.UserRepository
import org.koin.dsl.module

object Repository {

    val module = module(override = true) {
        single {
            UserRepository(api = get())
        }
        single {
            NotificationRepository(api = get())
        }
        single {
            TccRepository(api = get())
        }
        single {
            LibraryRepository(api = get())
        }
    }
}