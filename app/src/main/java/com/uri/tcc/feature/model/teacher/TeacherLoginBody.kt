package com.uri.tcc.feature.model.teacher

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeacherLoginBody(
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "senha") val password: String
) : Serializable