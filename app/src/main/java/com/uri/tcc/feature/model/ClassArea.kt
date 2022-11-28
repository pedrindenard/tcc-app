package com.uri.tcc.feature.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ClassArea(
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "id") val id: String
) : Serializable