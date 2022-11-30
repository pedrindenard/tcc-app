package com.uri.tcc.feature.domain.model.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Message(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "createdAt") val createdAt: String,
    @SerializedName(value = "createdByStudent") val createdByStudent: Boolean,
    @SerializedName(value = "text") val text: String,
    @SerializedName(value = "guidanceId") val guidanceId: String
) : Serializable