package com.uri.tcc.feature.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginTcc(
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "student") val student: LoginStudent?
) : Serializable