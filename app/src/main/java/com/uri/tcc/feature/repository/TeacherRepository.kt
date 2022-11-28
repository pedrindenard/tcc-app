package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.teacher.TeacherBody
import com.uri.tcc.feature.model.teacher.TeacherLoginBody
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherFilterDto
import com.uri.tcc.feature.remote.network.TeacherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File

class TeacherRepository(private val api: TeacherApi) {

    fun doLogin(teacher: TeacherLoginBody): Flow<Response<TeacherDto>> =
        flow { emit(api.doTeacherLogin(teacher)) }.flowOn(Dispatchers.IO)

    fun addTeacher(teacher: TeacherBody): Flow<Response<TeacherDto>> =
        flow { emit(api.addTeacher(teacher)) }.flowOn(Dispatchers.IO)

    fun updateTeacher(id: Int, teacher: TeacherBody): Flow<Response<TeacherDto>> =
        flow { emit(api.updateTeacher(id, teacher)) }.flowOn(Dispatchers.IO)

    fun deleteTeacher(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteTeacher(id)) }.flowOn(Dispatchers.IO)

    fun getTeacher(id: Int): Flow<Response<TeacherDto>> =
        flow { emit(api.getTeacher(id)) }.flowOn(Dispatchers.IO)

    fun fromTeacherToCoordinator(id: Int): Flow<Response<TeacherDto>> =
        flow { emit(api.fromTeacherToCoordinator(id)) }.flowOn(Dispatchers.IO)

    fun addDocTeacher(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.addDocTeacher(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun updateDocTeacher(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.updateDocTeacher(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun deleteDocTeacher(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteDocTeacher(id)) }.flowOn(Dispatchers.IO)

    fun getDocTeacher(id: Int): Flow<Response<TccDocumentDto>> =
        flow { emit(api.getDocTeacher(id)) }.flowOn(Dispatchers.IO)

    fun getTeacherCoordinator(id: Int): Flow<Response<TeacherFilterDto>> =
        flow { emit(api.getTeacherCoordinator(id)) }.flowOn(Dispatchers.IO)

    fun getTeacherByCourse(id: Int): Flow<Response<List<TeacherFilterDto>>> =
        flow { emit(api.getTeacherByCourse(id)) }.flowOn(Dispatchers.IO)

    fun addCourseTeacher(teacherId: Int, courseId: Int): Flow<Response<TeacherDto>> =
        flow { emit(api.addCourseTeacher(teacherId, courseId)) }.flowOn(Dispatchers.IO)
}