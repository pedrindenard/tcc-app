package com.uri.tcc.feature.presentation.fragment.message

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uri.tcc.core.Resource
import com.uri.tcc.feature.domain.body.message.MessageEditBody
import com.uri.tcc.feature.domain.model.message.MessageResponse
import com.uri.tcc.feature.domain.use_case.message.DoMessageEditUseCase
import com.uri.tcc.feature.domain.use_case.message.DoMessageSendUseCase
import com.uri.tcc.feature.domain.use_case.message.GetMessageUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MessageViewModel(
    private val getMessageUseCase: GetMessageUseCase,
    private val doMessageSendUseCase: DoMessageSendUseCase,
    private val doMessageEditUseCase: DoMessageEditUseCase
) : ViewModel() {

    private val _uiMessageEvent = MutableSharedFlow<UiMessageEvent>()
    val uiMessageEvent: SharedFlow<UiMessageEvent> = _uiMessageEvent

    private val _uiResponseEvent = MutableStateFlow<Resource<MessageResponse>>(Resource.Loading(true))
    val uiResponseEvent: StateFlow<Resource<MessageResponse>> = _uiResponseEvent

    fun getMessages() = viewModelScope.launch {
        getMessageUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiResponseEvent.value = Resource.Error(result.message)
                }
                is Resource.Failure -> {
                    _uiResponseEvent.value = Resource.Failure(result.throwable)
                }
                is Resource.Loading -> {
                    _uiResponseEvent.value = Resource.Loading(result.isLoading)
                }
                is Resource.Success -> {
                    _uiResponseEvent.value = Resource.Success(result.data)
                }
            }
        }.launchIn(this)
    }

    fun doSendMessage(text: String) = viewModelScope.launch {
        doMessageSendUseCase.invoke(text).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiMessageEvent.emit(UiMessageEvent.ErrorMessage(result.message))
                }
                is Resource.Failure -> {
                    _uiMessageEvent.emit(UiMessageEvent.FailureMessage(result.throwable))
                }
                is Resource.Loading -> {
                    _uiMessageEvent.emit(UiMessageEvent.LoadingMessage(text))
                }
                is Resource.Success -> {
                    _uiMessageEvent.emit(UiMessageEvent.SendMessage(result.data.message))
                }
            }
        }.launchIn(this)
    }

    fun doUpdateMessage(body: MessageEditBody) = viewModelScope.launch {
        doMessageEditUseCase.invoke(body).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiMessageEvent.emit(UiMessageEvent.ErrorMessage(result.message))
                }
                is Resource.Failure -> {
                    _uiMessageEvent.emit(UiMessageEvent.FailureMessage(result.throwable))
                }
                is Resource.Loading -> {
                    _uiMessageEvent.emit(UiMessageEvent.LoadingMessage(body.messageId))
                }
                is Resource.Success -> {
                    _uiMessageEvent.emit(UiMessageEvent.UpdateMessage(result.data.message))
                }
            }
        }.launchIn(this)
    }

    sealed class UiMessageEvent {
        data class SendMessage(val data: String) : UiMessageEvent()
        data class UpdateMessage(val data: String) : UiMessageEvent()
        data class ErrorMessage(val message: String) : UiMessageEvent()
        data class FailureMessage(val throwable: Throwable) : UiMessageEvent()
        data class LoadingMessage(val id: String) : UiMessageEvent()
    }
}