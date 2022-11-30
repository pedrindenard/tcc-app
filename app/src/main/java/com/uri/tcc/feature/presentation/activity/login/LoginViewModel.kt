package com.uri.tcc.feature.presentation.activity.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uri.tcc.core.Resource
import com.uri.tcc.feature.domain.body.auth.LoginBody
import com.uri.tcc.feature.domain.model.auth.LoginResponse
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.use_case.auth.DoLoginUseCase
import com.uri.tcc.feature.domain.use_case.form.ValidateEmail
import com.uri.tcc.feature.domain.use_case.form.ValidatePassword
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LoginViewModel(
    private val doLoginUseCase: DoLoginUseCase,
    private val validatePassword: ValidatePassword,
    private val validateName: ValidateEmail
) : ViewModel() {

    private val _uiFormEvent = MutableSharedFlow<UiLoginEvent>()
    val uiFormEvent: SharedFlow<UiLoginEvent> = _uiFormEvent

    private val _uiLoginEvent = MutableSharedFlow<Resource<LoginResponse>>()
    val uiLoginEvent: SharedFlow<Resource<LoginResponse>> = _uiLoginEvent

    fun doLogin(body: LoginBody) = viewModelScope.launch {
        val isValidPassword = validatePassword.execute(body.password)
        val isValidEmail = validateName.execute(body.email)
        var noneIsInvalid = false

        if (!isValidPassword.success) {
            _uiFormEvent.emit(UiLoginEvent.InvalidPassword(isValidPassword.message))
            noneIsInvalid = true
        }

        if (!isValidEmail.success) {
            _uiFormEvent.emit(UiLoginEvent.InvalidEmail(isValidEmail.message))
            noneIsInvalid = true
        }

        if (!noneIsInvalid) {
            doLoginUseCase.invoke(body).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiLoginEvent.emit(Resource.Error(result.message))
                    }
                    is Resource.Failure -> {
                        _uiLoginEvent.emit(Resource.Failure(result.throwable))
                    }
                    is Resource.Loading -> {
                        _uiLoginEvent.emit(Resource.Loading(result.isLoading))
                    }
                    is Resource.Success -> {
                        _uiLoginEvent.emit(Resource.Success(result.data))
                    }
                }
            }.launchIn(this)
        }
    }

    sealed class UiLoginEvent {
        data class InvalidEmail(val message: UIText) : UiLoginEvent()
        data class InvalidPassword(val message: UIText) : UiLoginEvent()
    }
}