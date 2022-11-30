package com.uri.tcc.feature.data.repository

import com.uri.tcc.feature.data.local.SharedPreferences
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.data.remote.dto.message.MessageChangedDto
import com.uri.tcc.feature.data.remote.dto.message.MessageResponseDto
import com.uri.tcc.feature.data.remote.network.Api
import com.uri.tcc.feature.domain.body.message.MessageEditBody
import com.uri.tcc.feature.domain.body.message.MessageSendBody
import com.uri.tcc.feature.domain.model.auth.LoginResponse
import com.uri.tcc.utils.Converters.fromJsonTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MessageRepository(private val api: Api, private val sharedPreferences: SharedPreferences) {

    fun getMessages(): Flow<Response<MessageResponseDto>> = flow {
        val result = sharedPreferences.get(SharedPreferencesImpl.Setting.USER_TOKEN).fromJsonTo<LoginResponse>()
        emit(api.getMessages(result!!.guidance.first().id))
    }.flowOn(Dispatchers.IO)

    fun doSendMessage(text: String): Flow<Response<MessageChangedDto>> = flow {
        val result = sharedPreferences.get(SharedPreferencesImpl.Setting.USER_TOKEN).fromJsonTo<LoginResponse>()
        val body = MessageSendBody(text, result!!.guidance.first().id)
        emit(api.doSendMessage(body))
    }.flowOn(Dispatchers.IO)

    fun doUpdateMessage(body: MessageEditBody): Flow<Response<MessageChangedDto>> = flow {
        emit(api.doUpdateMessage(body))
    }.flowOn(Dispatchers.IO)
}