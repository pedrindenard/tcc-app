package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Guidance(
    @SerializedName("alunoId") val studentId: Int,
    @SerializedName("orientacacaoId") val guidanceId: Int,
    @SerializedName("professorId") val teacherId: Int,
    @SerializedName("comentarios") val comments: GuidanceObjComment?,
    @SerializedName("datasOrientacoes") val guidance: List<GuidanceData>,
    @SerializedName("nomeAluno") val studentName: String,
    @SerializedName("nomeProfessor") val teacherName: String,
    @SerializedName("tituloTCC") val title: String
) : Serializable