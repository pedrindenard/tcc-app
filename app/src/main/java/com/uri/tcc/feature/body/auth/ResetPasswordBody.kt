package com.uri.tcc.feature.body.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResetPasswordBody(
    @SerializedName(value = "password") val password: String,
    @SerializedName(value = "newPassword") val newPassword: String
) : Serializable
