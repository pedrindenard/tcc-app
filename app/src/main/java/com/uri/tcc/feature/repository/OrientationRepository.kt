package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.guidance.GuidanceBody
import com.uri.tcc.feature.model.guidance.GuidanceCommentBody
import com.uri.tcc.feature.model.guidance.GuidanceDataBody
import com.uri.tcc.feature.remote.dto.guidance.GuidanceDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.network.OrientationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class OrientationRepository(private val api: OrientationApi) {

    fun addGuidance(guidance: GuidanceBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.addGuidance(guidance)) }.flowOn(Dispatchers.IO)

    fun addStudentComment(id: Int, comment: GuidanceCommentBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.addStudentComment(id, comment)) }.flowOn(Dispatchers.IO)

    fun addTeacherComment(id: Int, comment: GuidanceCommentBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.addTeacherComment(id, comment)) }.flowOn(Dispatchers.IO)

    fun updateCommentGuidance(id: Int, comment: GuidanceCommentBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.updateCommentGuidance(id, comment)) }.flowOn(Dispatchers.IO)

    fun updateDataGuidance(id: Int, data: GuidanceDataBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.updateDataGuidance(id, data)) }.flowOn(Dispatchers.IO)

    fun updateDateGuidance(id: Int, data: GuidanceDataBody): Flow<Response<GuidanceDto>> =
        flow { emit(api.updateDateGuidance(id, data)) }.flowOn(Dispatchers.IO)

    fun deleteCommentGuidance(id: Int): Flow<Response<GuidanceDto>> =
        flow { emit(api.deleteCommentGuidance(id)) }.flowOn(Dispatchers.IO)

    fun deleteDateGuidance(id: Int): Flow<Response<GuidanceDto>> =
        flow { emit(api.deleteDateGuidance(id)) }.flowOn(Dispatchers.IO)

    fun getGuidanceReport(id: Int): Flow<Response<TccDocumentDto>> =
        flow { emit(api.getGuidanceReport(id)) }.flowOn(Dispatchers.IO)

    fun getGuidanceComment(id: Int): Flow<Response<GuidanceDto.GuidanceObjCommentDto>> =
        flow { emit(api.getGuidanceComment(id)) }.flowOn(Dispatchers.IO)

    fun getGuidanceAdvisor(id: Int): Flow<Response<GuidanceDto>> =
        flow { emit(api.getGuidanceAdvisor(id)) }.flowOn(Dispatchers.IO)

    fun getGuidanceStudent(id: Int): Flow<Response<GuidanceDto>> =
        flow { emit(api.getGuidanceStudent(id)) }.flowOn(Dispatchers.IO)

    fun getGuidanceTeacher(id: Int): Flow<Response<List<GuidanceDto>>> =
        flow { emit(api.getGuidanceTeacher(id)) }.flowOn(Dispatchers.IO)
}