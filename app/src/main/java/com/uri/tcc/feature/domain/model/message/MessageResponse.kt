package com.uri.tcc.feature.domain.model.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageResponse(
    @SerializedName(value = "data") val data: MessageData
) : Serializable