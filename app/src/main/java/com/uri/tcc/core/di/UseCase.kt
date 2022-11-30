package com.uri.tcc.core.di

import com.uri.tcc.feature.domain.use_case.auth.DoLoginUseCase
import com.uri.tcc.feature.domain.use_case.auth.DoRegisterUseCase
import com.uri.tcc.feature.domain.use_case.auth.DoResetPasswordUseCase
import com.uri.tcc.feature.domain.use_case.class_all.GetAllClassUseCase
import com.uri.tcc.feature.domain.use_case.form.*
import com.uri.tcc.feature.domain.use_case.message.DoMessageEditUseCase
import com.uri.tcc.feature.domain.use_case.message.DoMessageSendUseCase
import com.uri.tcc.feature.domain.use_case.message.GetMessageUseCase
import org.koin.dsl.module

object UseCase {

    val module = module(override = true) {
        single {
            DoLoginUseCase(repository = get())
        }
        single {
            DoRegisterUseCase(repository = get())
        }
        single {
            DoResetPasswordUseCase(repository = get())
        }
        single {
            GetAllClassUseCase(repository = get())
        }
        single {
            GetMessageUseCase(repository = get())
        }
        single {
            DoMessageEditUseCase(repository = get())
        }
        single {
            DoMessageSendUseCase(repository = get())
        }
        single {
            ValidateName()
        }
        single {
            ValidatePassword()
        }
        single {
            ValidateEmail()
        }
        single {
            ValidateCPF()
        }
        single {
            ValidateClass()
        }
    }
}