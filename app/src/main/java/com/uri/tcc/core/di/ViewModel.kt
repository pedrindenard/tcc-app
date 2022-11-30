package com.uri.tcc.core.di

import com.uri.tcc.feature.presentation.activity.login.LoginViewModel
import com.uri.tcc.feature.presentation.activity.register.RegisterViewModel
import com.uri.tcc.feature.presentation.fragment.message.MessageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModel {

    val module = module(override = true) {
        viewModel {
            LoginViewModel(
                doLoginUseCase = get(),
                validatePassword = get(),
                validateName = get()
            )
        }
        viewModel {
            RegisterViewModel(
                doRegisterUseCase = get(),
                getAllClassUseCase = get(),
                validateName = get(),
                validateEmail = get(),
                validateCPF = get(),
                validatePassword = get(),
                validateClass = get()
            )
        }
        viewModel {
            MessageViewModel(
                getMessageUseCase = get(),
                doMessageEditUseCase = get(),
                doMessageSendUseCase = get()
            )
        }
    }
}