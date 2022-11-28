package com.uri.tcc.feature.repository

import com.uri.tcc.feature.remote.dto.auth.AllClassResponseDto
import com.uri.tcc.feature.remote.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class LibraryRepository(private val api: Api) {

    fun getAllClass(): Flow<Response<List<AllClassResponseDto>>> =
        flow { emit(api.getAllClasses()) }.flowOn(Dispatchers.IO)
}