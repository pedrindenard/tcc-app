package com.uri.tcc.feature.model.teacher

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeacherFilter(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "nome") val name: String
) : Serializable