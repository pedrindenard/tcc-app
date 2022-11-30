package com.uri.tcc.feature.data.remote.dto.message

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.domain.model.message.MessageChanged
import java.io.Serializable

data class MessageChangedDto(
    @SerializedName(value = "message") val message: String?
) : Serializable {

    val response: MessageChanged
        get() = MessageChanged(
            message = message ?: ""
        )
}