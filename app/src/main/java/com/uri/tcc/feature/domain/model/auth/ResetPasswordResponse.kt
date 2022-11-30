package com.uri.tcc.feature.domain.model.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResetPasswordResponse(
    @SerializedName(value = "message") val message: String
) : Serializable