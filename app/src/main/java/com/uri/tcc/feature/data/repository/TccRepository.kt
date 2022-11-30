package com.uri.tcc.feature.data.repository

import com.uri.tcc.feature.domain.body.tcc.TccRegisterBody
import com.uri.tcc.feature.domain.body.tcc.TccUpdateBody
import com.uri.tcc.feature.data.remote.dto.tcc.TccRegisterResponseDto
import com.uri.tcc.feature.data.remote.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class TccRepository(private val api: Api) {

    fun doRegister(body: TccRegisterBody): Flow<Response<TccRegisterResponseDto>> =
        flow { emit(api.doRegisterTcc(body)) }.flowOn(Dispatchers.IO)

    fun doUpdate(body: TccUpdateBody): Flow<Response<TccRegisterResponseDto>> =
        flow { emit(api.doUpdateTcc(body)) }.flowOn(Dispatchers.IO)
}