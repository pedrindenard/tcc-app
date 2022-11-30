package com.uri.tcc.feature.presentation.activity.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uri.tcc.core.Resource
import com.uri.tcc.feature.domain.body.auth.RegisterBody
import com.uri.tcc.feature.domain.model.auth.RegisterResponse
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.library.AllClassResponse
import com.uri.tcc.feature.domain.use_case.auth.DoRegisterUseCase
import com.uri.tcc.feature.domain.use_case.class_all.GetAllClassUseCase
import com.uri.tcc.feature.domain.use_case.form.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val doRegisterUseCase: DoRegisterUseCase,
    private val getAllClassUseCase: GetAllClassUseCase,
    private val validateName: ValidateName,
    private val validateEmail: ValidateEmail,
    private val validateCPF: ValidateCPF,
    private val validatePassword: ValidatePassword,
    private val validateClass: ValidateClass
) : ViewModel() {

    private val _uiFormEvent = MutableSharedFlow<UiRegisterEvent>()
    val uiFormEvent: SharedFlow<UiRegisterEvent> = _uiFormEvent

    private val _uiLoginEvent = MutableSharedFlow<Resource<RegisterResponse>>()
    val uiLoginEvent: SharedFlow<Resource<RegisterResponse>> = _uiLoginEvent

    private val _uiClassEvent = MutableSharedFlow<Resource<List<AllClassResponse>>>()
    val uiClassEvent: SharedFlow<Resource<List<AllClassResponse>>> = _uiClassEvent

    fun doRegister(body: RegisterBody) = viewModelScope.launch {
        val isValidName = validateName.execute(body.name)
        val isValidEmail = validateEmail.execute(body.email)
        val isValidCPF = validateCPF.execute(body.cpf)
        val isValidPassword = validatePassword.execute(body.password)
        val isValidClass = validateClass.execute(body.classId)

        var noneIsInvalid = false

        if (!isValidName.success) {
            _uiFormEvent.emit(UiRegisterEvent.InvalidName(isValidName.message))
            noneIsInvalid = true
        }

        if (!isValidEmail.success) {
            _uiFormEvent.emit(UiRegisterEvent.InvalidEmail(isValidEmail.message))
            noneIsInvalid = true
        }

        if (!isValidCPF.success) {
            _uiFormEvent.emit(UiRegisterEvent.InvalidCPF(isValidCPF.message))
            noneIsInvalid = true
        }

        if (!isValidPassword.success) {
            _uiFormEvent.emit(UiRegisterEvent.InvalidPassword(isValidPassword.message))
            noneIsInvalid = true
        }

        if (!isValidClass.success) {
            _uiFormEvent.emit(UiRegisterEvent.InvalidClass(isValidClass.message))
            noneIsInvalid = true
        }

        if (!noneIsInvalid) {
            doRegisterUseCase.invoke(body).onEach { result ->
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

    fun getAllClass() = viewModelScope.launch {
        getAllClassUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiClassEvent.emit(Resource.Error(result.message))
                }
                is Resource.Failure -> {
                    _uiClassEvent.emit(Resource.Failure(result.throwable))
                }
                is Resource.Loading -> {
                    _uiClassEvent.emit(Resource.Loading(result.isLoading))
                }
                is Resource.Success -> {
                    _uiClassEvent.emit(Resource.Success(result.data))
                }
            }
        }.launchIn(this)
    }

    sealed class UiRegisterEvent {
        data class InvalidName(val message: UIText) : UiRegisterEvent()
        data class InvalidEmail(val message: UIText) : UiRegisterEvent()
        data class InvalidCPF(val message: UIText) : UiRegisterEvent()
        data class InvalidPassword(val message: UIText) : UiRegisterEvent()
        data class InvalidClass(val message: UIText) : UiRegisterEvent()
    }
}