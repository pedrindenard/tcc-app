package com.uri.tcc.feature.body.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegisterBody(
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "password") val password: String,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "cpf") val cpf: String,
    @SerializedName(value = "classId") val classId: String
) : Serializable