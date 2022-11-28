package com.uri.tcc.feature.repository

import com.uri.tcc.feature.body.auth.LoginBody
import com.uri.tcc.feature.body.auth.RegisterBody
import com.uri.tcc.feature.body.auth.ResetPasswordBody
import com.uri.tcc.feature.remote.dto.auth.LoginResponseDto
import com.uri.tcc.feature.remote.dto.auth.RegisterResponseDto
import com.uri.tcc.feature.remote.dto.auth.ResetPasswordResponseDto
import com.uri.tcc.feature.remote.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class UserRepository(private val api: Api) {

    fun doLogin(body: LoginBody): Flow<Response<LoginResponseDto>> =
        flow { emit(api.doLogin(body)) }.flowOn(Dispatchers.IO)

    fun doRegister(body: RegisterBody): Flow<Response<RegisterResponseDto>> =
        flow { emit(api.doRegister(body)) }.flowOn(Dispatchers.IO)

    fun doResetPassword(body: ResetPasswordBody): Flow<Response<ResetPasswordResponseDto>> =
        flow { emit(api.doResetPassword(body)) }.flowOn(Dispatchers.IO)
}