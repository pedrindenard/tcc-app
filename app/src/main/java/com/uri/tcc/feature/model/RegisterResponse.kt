package com.uri.tcc.feature.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegisterResponse(
    @SerializedName(value = "message") val message: String
) : Serializable