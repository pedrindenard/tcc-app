package com.uri.tcc.feature.domain.model.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageData(
    @SerializedName(value = "messages") val messages: List<Message>
) : Serializable