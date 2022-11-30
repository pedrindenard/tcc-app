package com.uri.tcc.feature.data.repository

import com.uri.tcc.feature.data.local.SharedPreferences
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.data.remote.dto.auth.LoginResponseDto
import com.uri.tcc.feature.data.remote.dto.auth.RegisterResponseDto
import com.uri.tcc.feature.data.remote.dto.auth.ResetPasswordResponseDto
import com.uri.tcc.feature.data.remote.network.Api
import com.uri.tcc.feature.domain.body.auth.LoginBody
import com.uri.tcc.feature.domain.body.auth.RegisterBody
import com.uri.tcc.feature.domain.body.auth.ResetPasswordBody
import com.uri.tcc.utils.Converters.toJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import retrofit2.Response

class UserRepository(private val api: Api, private val sharedPreferences: SharedPreferences) {

    fun doLogin(body: LoginBody): Flow<Response<LoginResponseDto>> =
        flow { emit(api.doLogin(body)) }.flowOn(Dispatchers.IO).onEach { result ->
            if (result.isSuccessful) {
                val login = LoginBody(body.email, body.password)
                sharedPreferences.insert(login.toJson(), SharedPreferencesImpl.Setting.USER_LOGIN)
                sharedPreferences.insert(result.body()!!.response.toJson(), SharedPreferencesImpl.Setting.USER_TOKEN)
            }
        }

    fun doRegister(body: RegisterBody): Flow<Response<RegisterResponseDto>> =
        flow { emit(api.doRegister(body)) }.flowOn(Dispatchers.IO).onEach { result ->
            if (result.isSuccessful) {
                val login = LoginBody(body.email, body.password)
                sharedPreferences.insert(login.toJson(), SharedPreferencesImpl.Setting.USER_LOGIN)
            }
        }

    fun doResetPassword(body: ResetPasswordBody): Flow<Response<ResetPasswordResponseDto>> =
        flow { emit(api.doResetPassword(body)) }.flowOn(Dispatchers.IO)
}