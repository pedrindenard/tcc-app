package com.uri.tcc.feature.domain.model.auth

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginStudent(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "name") val name: String
) : Serializable