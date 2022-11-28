package com.uri.tcc.feature.model.library

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Library(
    @SerializedName("descricaoTCC") val description: String,
    @SerializedName("id") val id: Int,
    @SerializedName("idDoc") val idDoc: Int,
    @SerializedName("nomeAluno") val studentName: String,
    @SerializedName("nomeCurso") val teacherName: String,
    @SerializedName("nomeOrientador") val advisorName: String,
    @SerializedName("tituloTCC") val title: String
) : Serializable