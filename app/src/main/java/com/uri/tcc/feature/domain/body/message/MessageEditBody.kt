package com.uri.tcc.feature.domain.body.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageEditBody(
    @SerializedName(value = "messageId") val messageId: String,
    @SerializedName(value = "byUser") val byUser: Boolean,
    @SerializedName(value = "text") val text: Serializable,
    @SerializedName(value = "guidanceId") val guidanceId: String
) : Serializable