package com.uri.tcc.feature.model.course

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Course(
    @SerializedName(value = "idCurso") val id: Int,
    @SerializedName(value = "nome") val name: String,
    @SerializedName(value = "areacurso") val area: String
) : Serializable