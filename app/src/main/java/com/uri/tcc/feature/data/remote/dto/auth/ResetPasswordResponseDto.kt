package com.uri.tcc.feature.data.remote.dto.auth

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.domain.model.auth.ResetPasswordResponse
import java.io.Serializable

data class ResetPasswordResponseDto(
    @SerializedName(value = "message") val message: String?
) : Serializable {

    val response: ResetPasswordResponse
        get() = ResetPasswordResponse(
            message = message ?: ""
        )
}