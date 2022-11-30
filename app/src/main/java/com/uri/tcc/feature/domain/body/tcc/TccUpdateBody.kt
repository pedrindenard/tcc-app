package com.uri.tcc.feature.domain.body.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccUpdateBody(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "summary") val summary: String,
    @SerializedName(value = "docFileLink") val docFileLink: String
) : Serializable