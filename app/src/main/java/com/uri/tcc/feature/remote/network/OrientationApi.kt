package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.guidance.GuidanceBody
import com.uri.tcc.feature.model.guidance.GuidanceCommentBody
import com.uri.tcc.feature.model.guidance.GuidanceDataBody
import com.uri.tcc.feature.remote.dto.guidance.GuidanceDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface OrientationApi {

    /* POST */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/add")
    suspend fun addGuidance(@Body guidance: GuidanceBody): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/add/aluno/{orientacaoId}/comentario")
    suspend fun addStudentComment(@Path(value = "orientacaoId") id: Int, @Body comment: GuidanceCommentBody): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/add/professor/{orientacaoId}/comentario")
    suspend fun addTeacherComment(@Path(value = "orientacaoId") id: Int, @Body comment: GuidanceCommentBody): Response<GuidanceDto>

    /* PUT */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/put/{comentarioId}/comentario")
    suspend fun updateCommentGuidance(@Path(value = "orientacaoId") id: Int, @Body comment: GuidanceCommentBody): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/put/{dataOrientacaoId}/atualizaData")
    suspend fun updateDataGuidance(@Path(value = "orientacaoId") id: Int, @Body data: GuidanceDataBody): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/put/{orientacaoId}/marcaData")
    suspend fun updateDateGuidance(@Path(value = "orientacaoId") id: Int, @Body data: GuidanceDataBody): Response<GuidanceDto>

    /* DELETE */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/delete/{comentarioId}/comentario")
    suspend fun deleteCommentGuidance(@Path(value = "comentarioId") id: Int): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "rientacao/delete/{dataOrientacaoId}")
    suspend fun deleteDateGuidance(@Path(value = "comentarioId") id: Int): Response<GuidanceDto>

    /* GET */
    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/{orientacaoId}/getRelatorio")
    suspend fun getGuidanceReport(@Path(value = "orientacaoId") id: Int): Response<TccDocumentDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/get/{orientacaoId}/comentario")
    suspend fun getGuidanceComment(@Path(value = "orientacaoId") id: Int): Response<GuidanceDto.GuidanceObjCommentDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/getOrientacao/{orientacaoId}")
    suspend fun getGuidanceAdvisor(@Path(value = "orientacaoId") id: Int): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/getOrientacaoAluno/{alunoId}")
    suspend fun getGuidanceStudent(@Path(value = "alunoId") id: Int): Response<GuidanceDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "orientacao/getOrientacaoProfessor/{professorId}")
    suspend fun getGuidanceTeacher(@Path(value = "professorId") id: Int): Response<List<GuidanceDto>>
}