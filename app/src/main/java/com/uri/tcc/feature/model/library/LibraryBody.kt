package com.uri.tcc.feature.model.library

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LibraryBody(
    @SerializedName("descricaoTCC") val description: String,
    @SerializedName("nomeAluno") val studentName: String,
    @SerializedName("nomeCurso") val courseName: String,
    @SerializedName("nomeOrientador") val advisorName: String,
    @SerializedName("tituloTCC") val title: String
) : Serializable