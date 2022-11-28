package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceDataBody(
    @SerializedName(value = "data") val data: String
) : Serializable