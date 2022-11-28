package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccBody(
    @SerializedName(value = "alunoId") val studentId: Int,
    @SerializedName(value = "descricao") val teacherId: String,
    @SerializedName(value = "professorId") val description: String,
    @SerializedName(value = "titulo") val title: String
) : Serializable