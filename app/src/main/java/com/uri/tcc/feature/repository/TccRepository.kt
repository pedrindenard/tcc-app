package com.uri.tcc.feature.repository

import com.uri.tcc.feature.body.tcc.TccRegisterBody
import com.uri.tcc.feature.remote.dto.tcc.TccRegisterResponseDto
import com.uri.tcc.feature.remote.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class TccRepository(private val api: Api) {

    fun doRegister(body: TccRegisterBody): Flow<Response<TccRegisterResponseDto>> =
        flow { emit(api.doRegisterTcc(body)) }.flowOn(Dispatchers.IO)
}