package com.uri.tcc.feature.remote.dto.guidance

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.guidance.Guidance
import com.uri.tcc.feature.model.guidance.GuidanceComment
import com.uri.tcc.feature.model.guidance.GuidanceData
import com.uri.tcc.feature.model.guidance.GuidanceObjComment

data class GuidanceDto(
    @SerializedName("alunoId") val studentId: Int?,
    @SerializedName("orientacacaoId") val guidanceId: Int?,
    @SerializedName("professorId") val teacherId: Int?,
    @SerializedName("comentarios") val comments: GuidanceObjCommentDto?,
    @SerializedName("datasOrientacoes") val guidance: List<GuidanceDataDto>?,
    @SerializedName("nomeAluno") val studentName: String?,
    @SerializedName("nomeProfessor") val teacherName: String?,
    @SerializedName("tituloTCC") val title: String?
) {

    data class GuidanceObjCommentDto(
        @SerializedName("comentarios") val comments: List<GuidanceCommentDto>?
    ) {
        val response: GuidanceObjComment
            get() = GuidanceObjComment(
                comments = comments?.map { it.response } ?: emptyList()
            )
    }

    data class GuidanceCommentDto(
        @SerializedName("autor") val author: String?,
        @SerializedName("comentario") val comment: String?,
        @SerializedName("dataComentario") val commentDate: String?,
        @SerializedName("idComentario") val commentId: Int?
    ) {
        val response: GuidanceComment
            get() = GuidanceComment(
                author = author ?: "",
                comment = comment ?: "",
                commentDate = commentDate ?: "",
                commentId = commentId ?: 0
            )
    }

    data class GuidanceDataDto(
        @SerializedName("data") val data: String?,
        @SerializedName("idDataOrientacao") val id: Int?
    ) {
        val response: GuidanceData
            get() = GuidanceData(
                data = data ?: "",
                id = id ?: 0
            )
    }

    val response: Guidance
        get() = Guidance(
            title = title ?: "",
            studentName = studentName ?: "",
            teacherName = teacherName ?: "",
            studentId = studentId ?: 0,
            guidanceId = guidanceId ?: 0,
            teacherId = teacherId ?: 0,
            comments = comments?.response,
            guidance = guidance?.map { it.response } ?: emptyList()
        )
}