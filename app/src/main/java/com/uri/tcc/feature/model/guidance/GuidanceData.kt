package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceData(
    @SerializedName("data") val data: String,
    @SerializedName("idDataOrientacao") val id: Int
) : Serializable