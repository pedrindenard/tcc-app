package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.library.LibraryBody
import com.uri.tcc.feature.model.library.LibraryCourseBody
import com.uri.tcc.feature.model.library.LibraryTccBody
import com.uri.tcc.feature.remote.dto.library.LibraryDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface LibraryApi {

    /* LIBRARY CRUD */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "biblioteca/add")
    suspend fun addLibrary(@Body library: LibraryBody): Response<LibraryDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "biblioteca/{bibliotecaId}/update")
    suspend fun updateLibrary(@Path(value = "bibliotecaId") id: Int, @Body library: LibraryBody): Response<LibraryDto>

    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "biblioteca/{bibliotecaId}/update")
    suspend fun deleteLibrary(@Path(value = "bibliotecaId") id: Int): Response<Void>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "biblioteca/getBiblioteca/{bibliotecaId}")
    suspend fun getLibrary(@Path(value = "bibliotecaId") id: Int): Response<LibraryDto>

    /* DOCUMENT LIBRARY */
    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "biblioteca/add/{bibliotecaId}/document")
    suspend fun addDocLibrary(@Path(value = "bibliotecaId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "biblioteca/update/{bibliotecaId}/document")
    suspend fun updateDocLibrary(@Path(value = "bibliotecaId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "biblioteca/delete/{bibliotecaId}/document")
    suspend fun deleteDocLibrary(@Path(value = "bibliotecaId") id: Int): Response<Void>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "biblioteca/get/{bibliotecaId}/document")
    suspend fun getDocLibrary(@Path(value = "bibliotecaId") id: Int): Response<TccDocumentDto>

    /* LIBRARY FILTER */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "biblioteca/getBiblioteca/curso")
    suspend fun getCourseLibrary(@Body course: LibraryCourseBody): Response<List<LibraryDto>>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "getBiblioteca/tituloTCC")
    suspend fun getTccLibrary(@Body tcc: LibraryTccBody): Response<List<LibraryDto>>
}