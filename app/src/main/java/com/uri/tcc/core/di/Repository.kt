package com.uri.tcc.core.di

import com.uri.tcc.feature.repository.*
import org.koin.dsl.module

object Repository {

    val module = module(override = true) {
        single {
            StudentRepository(api = get())
        }
        single {
            TeacherRepository(api = get())
        }
        single {
            OrientationRepository(api = get())
        }
        single {
            TccRepository(api = get())
        }
        single {
            CourseRepository(api = get())
        }
        single {
            LibraryRepository(api = get())
        }
    }
}