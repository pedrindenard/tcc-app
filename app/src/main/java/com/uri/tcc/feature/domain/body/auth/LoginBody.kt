package com.uri.tcc.feature.domain.body.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginBody(
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "password") val password: String
) : Serializable