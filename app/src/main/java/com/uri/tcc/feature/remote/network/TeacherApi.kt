package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.teacher.TeacherBody
import com.uri.tcc.feature.model.teacher.TeacherLoginBody
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherFilterDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface TeacherApi {

    /* LOGIN TEACHER */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "professor/login")
    suspend fun doTeacherLogin(@Body teacher: TeacherLoginBody): Response<TeacherDto>

    /* TEACHER CRUD */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "professor/add")
    suspend fun addTeacher(@Body teacher: TeacherBody): Response<TeacherDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "professor/{professorId}/delete")
    suspend fun updateTeacher(@Path(value = "professorId") id: Int, @Body teacher: TeacherBody): Response<TeacherDto>

    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "professor/{professorId}/delete")
    suspend fun deleteTeacher(@Path(value = "professorId") id: Int): Response<Void>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "professor/getProfessor/{professorId}")
    suspend fun getTeacher(@Path(value = "professorId") id: Int): Response<TeacherDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "professor/{professorId}/coordenador")
    suspend fun fromTeacherToCoordinator(@Path(value = "professorId") id: Int): Response<TeacherDto>

    /* TEACHER FILTERS */
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "professor/{cursoId}/coordenador")
    suspend fun getTeacherCoordinator(@Path(value = "cursoId") id: Int): Response<TeacherFilterDto>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "professor/{cursoId}/getProfessor")
    suspend fun getTeacherByCourse(@Path(value = "cursoId") id: Int): Response<List<TeacherFilterDto>>

    /* DOCUMENT TEACHER */
    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "professor/add/{professorId}/document")
    suspend fun addDocTeacher(@Path(value = "professorId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "professor/update/{professorId}/document")
    suspend fun updateDocTeacher(@Path(value = "professorId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "professor/delete/{professorId}/document")
    suspend fun deleteDocTeacher(@Path(value = "professorId") id: Int): Response<Void>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "professor/get/{professorId}/document")
    suspend fun getDocTeacher(@Path(value = "professorId") id: Int): Response<TccDocumentDto>

    /* COURSE */
    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "professor/{professorId}/cursos/{cursoId}")
    suspend fun addCourseTeacher(@Path(value = "professorId") teacherId: Int, @Path(value = "cursoId") courseId: Int): Response<TeacherDto>
}