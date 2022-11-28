package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.student.StudentBody
import com.uri.tcc.feature.model.student.StudentLoginBody
import com.uri.tcc.feature.remote.dto.student.StudentDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherFilterDto
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface StudentApi {

    /* LOGIN STUDENT */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "aluno/login")
    suspend fun doStudentLogin(@Body student: StudentLoginBody): Response<StudentDto>

    /* CRUD STUDENT */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "aluno/add")
    suspend fun addStudent(@Body student: StudentBody): Response<StudentDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "aluno/{alunoId}/put")
    suspend fun updateStudent(@Path(value = "alunoId") id: Int, @Body student: StudentBody): Response<StudentDto>

    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "aluno/{alunoId}/delete")
    suspend fun deleteStudent(@Path(value = "alunoId") id: Int): Response<Void>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "aluno/getAluno/{alunoId}")
    suspend fun getStudent(@Path(value = "alunoId") id: Int): Response<StudentDto>

    /* CRUD DOCUMENT STUDENT */
    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "aluno/add/{alunoId}/document")
    suspend fun addDocStudent(@Path(value = "alunoId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "aluno/update/{alunoId}/document")
    suspend fun updateDocStudent(@Path(value = "alunoId") id: Int, @Part file: MultipartBody.Part): Response<TccDocumentDto>

    @Headers(value = ["Content-Type: application/json"])
    @DELETE(value = "aluno/delete/{alunoId}/document")
    suspend fun deleteDocStudent(@Path(value = "alunoId") id: Int): Response<Void>

    @Multipart
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "aluno/get/{alunoId}/document")
    suspend fun getDocStudent(@Path(value = "alunoId") id: Int): Response<TccDocumentDto>

    /* STUDENT FILTER */
    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "aluno/{cursoId}/getProfessor")
    suspend fun getStudentByCourse(@Path(value = "cursoId") id: Int): Response<List<TeacherFilterDto>>
}