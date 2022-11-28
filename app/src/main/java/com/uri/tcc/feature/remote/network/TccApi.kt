package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.tcc.TccBody
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.tcc.TccDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface TccApi {

    /* TCC CRUD */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "tcc/add")
    suspend fun addTcc(@Body tcc: TccBody): Response<TccDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "tcc/{tccId}/update")
    suspend fun updateTcc(@Path("tccId") id: Int, @Body tcc: TccBody): Response<TccDto>

    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "tcc/{tccId}/delete")
    suspend fun deleteTcc(@Path("tccId") id: Int): Response<Void>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "tcc/{tccId}/getTCC")
    suspend fun getTcc(@Path("tccId") id: Int): Response<TccDto>

    /* TCC DOCUMENT CRUD */
    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "tcc/add/{tccId}/document")
    suspend fun addDocTcc(@Path("tccId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "tcc/update/{tccId}/document")
    suspend fun updateDocTcc(@Path("tccId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "tcc/delete/{tccId}/document")
    suspend fun deleteDocTcc(@Path("tccId") id: Int): Response<Void>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "tcc/get/{tccId}/document")
    suspend fun getDocTcc(@Path("tccId") id: Int): Response<TccDocumentDto>

    /* TCC LIBRARY */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "tcc/{tccId}/biblioteca")
    suspend fun addTccToLibrary(@Path("tccId") id: Int): Response<Void>
}