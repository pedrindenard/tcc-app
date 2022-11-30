package com.uri.tcc.feature.data.remote.dto.message

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.domain.model.message.Message
import com.uri.tcc.feature.domain.model.message.MessageData
import com.uri.tcc.feature.domain.model.message.MessageResponse
import java.io.Serializable

data class MessageResponseDto(
    @SerializedName(value = "data") val data: MessageDataDto?
) : Serializable {

    data class MessageDataDto(
        @SerializedName(value = "messages") val messages: List<MessageDto>?
    ) : Serializable {

        data class MessageDto(
            @SerializedName(value = "id") val id: String?,
            @SerializedName(value = "createdAt") val createdAt: String?,
            @SerializedName(value = "createdByStudent") val createdByStudent: Boolean?,
            @SerializedName(value = "text") val text: String?,
            @SerializedName(value = "guidanceId") val guidanceId: String?
        ) : Serializable {

            val response: Message
                get() = Message(
                    id = id ?: "",
                    createdAt = createdAt ?: "",
                    createdByStudent = createdByStudent ?: false,
                    text = text ?: "",
                    guidanceId = guidanceId ?: "",
                )
        }

        val response: MessageData
            get() = MessageData(
                messages = messages?.map { it.response } ?: emptyList()
            )
    }

    val response: MessageResponse
        get() = MessageResponse(
            data = data?.response ?: MessageData(
                messages = emptyList()
            )
        )
}