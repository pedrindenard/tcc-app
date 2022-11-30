package com.uri.tcc.feature.domain.model.message

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MessageChanged(
    @SerializedName(value = "message") val message: String
) : Serializable