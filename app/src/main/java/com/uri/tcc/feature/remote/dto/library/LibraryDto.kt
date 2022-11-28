package com.uri.tcc.feature.remote.dto.library

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.library.Library

data class LibraryDto(
    @SerializedName("descricaoTCC") val description: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("idDoc") val idDoc: Int?,
    @SerializedName("nomeAluno") val studentName: String?,
    @SerializedName("nomeCurso") val teacherName: String?,
    @SerializedName("nomeOrientador") val advisorName: String?,
    @SerializedName("tituloTCC") val title: String?
) {
    val response: Library
        get() = Library(
            id = id ?: 0,
            idDoc = idDoc ?: 0,
            description = description ?: "",
            studentName = studentName ?: "",
            teacherName = teacherName ?: "",
            advisorName = advisorName ?: "",
            title = title ?: ""
        )
}