package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tcc(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "docId") val docId: Int,
    @SerializedName(value = "titulo") val title: String,
    @SerializedName(value = "descricao") val description: String,
    @SerializedName(value = "alunoDTO") val student: TccPeople?,
    @SerializedName(value = "professor") val teacher: TccPeople?
) : Serializable