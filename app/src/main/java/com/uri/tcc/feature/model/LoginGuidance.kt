package com.uri.tcc.feature.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginGuidance(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "tcc") val tcc: LoginTcc?
) : Serializable