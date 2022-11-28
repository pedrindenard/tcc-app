package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.tcc.TccBody
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.tcc.TccDto
import com.uri.tcc.feature.remote.network.TccApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File

class TccRepository(private val api: TccApi) {

    fun addTcc(tcc: TccBody): Flow<Response<TccDto>> =
        flow { emit(api.addTcc(tcc)) }.flowOn(Dispatchers.IO)

    fun updateTcc(id: Int, tcc: TccBody): Flow<Response<TccDto>> =
        flow { emit(api.updateTcc(id, tcc)) }.flowOn(Dispatchers.IO)

    fun deleteTcc(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteTcc(id)) }.flowOn(Dispatchers.IO)

    fun getTcc(id: Int): Flow<Response<TccDto>> =
        flow { emit(api.getTcc(id)) }.flowOn(Dispatchers.IO)

    fun addDocument(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.addDocTcc(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun updateDocument(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.updateDocTcc(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun deleteDocument(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteDocTcc(id)) }.flowOn(Dispatchers.IO)

    fun getDocument(id: Int): Flow<Response<TccDocumentDto>> =
        flow { emit(api.getDocTcc(id)) }.flowOn(Dispatchers.IO)

    fun addToLibrary(id: Int): Flow<Response<Void>> =
        flow { emit(api.addTccToLibrary(id)) }.flowOn(Dispatchers.IO)
}