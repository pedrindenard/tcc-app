package com.uri.tcc.feature.model.student

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StudentTcc(
    @SerializedName(value = "idTCC") val idTcc: Int,
    @SerializedName(value = "idProfessor") val idTeacher: Int,
    @SerializedName(value = "descricao") val description: String,
    @SerializedName(value = "nomeProfessor") val nameTeacher: String,
    @SerializedName(value = "titulo") val title: String
): Serializable