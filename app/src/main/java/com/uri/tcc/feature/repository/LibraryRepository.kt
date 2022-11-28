package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.library.LibraryBody
import com.uri.tcc.feature.model.library.LibraryCourseBody
import com.uri.tcc.feature.model.library.LibraryTccBody
import com.uri.tcc.feature.remote.dto.library.LibraryDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.network.LibraryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File

class LibraryRepository(private val api: LibraryApi) {

    fun addLibrary(library: LibraryBody): Flow<Response<LibraryDto>> =
        flow { emit(api.addLibrary(library)) }.flowOn(Dispatchers.IO)

    fun updateLibrary(id: Int, library: LibraryBody): Flow<Response<LibraryDto>> =
        flow { emit(api.updateLibrary(id, library)) }.flowOn(Dispatchers.IO)

    fun deleteLibrary(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteLibrary(id)) }.flowOn(Dispatchers.IO)

    fun getLibrary(id: Int): Flow<Response<LibraryDto>> =
        flow { emit(api.getLibrary(id)) }.flowOn(Dispatchers.IO)

    fun addDocLibrary(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.addDocLibrary(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun updateDocLibrary(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.updateDocLibrary(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun deleteDocLibrary(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteDocLibrary(id)) }.flowOn(Dispatchers.IO)

    fun getDocLibrary(id: Int): Flow<Response<TccDocumentDto>> =
        flow { emit(api.getDocLibrary(id)) }.flowOn(Dispatchers.IO)

    fun getCourseLibrary(course: LibraryCourseBody): Flow<Response<List<LibraryDto>>> =
        flow { emit(api.getCourseLibrary(course)) }.flowOn(Dispatchers.IO)

    fun getTccLibrary(tcc: LibraryTccBody): Flow<Response<List<LibraryDto>>> =
        flow { emit(api.getTccLibrary(tcc)) }.flowOn(Dispatchers.IO)
}