package com.uri.tcc.feature.domain.body.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccRegisterBody(
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "summary") val summary: String
) : Serializable