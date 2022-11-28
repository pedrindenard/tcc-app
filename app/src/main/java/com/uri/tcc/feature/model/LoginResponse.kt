package com.uri.tcc.feature.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName(value = "token") val token: String,
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "guidance") val guidance: List<LoginGuidance>
) : Serializable