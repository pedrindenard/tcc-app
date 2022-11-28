package com.uri.tcc.feature.model.student

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StudentLoginBody(
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "senha") val password: String
) : Serializable