package com.uri.tcc.feature.domain.model.library

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AllClassResponse(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "classArea") val classArea: ClassArea?
) : Serializable