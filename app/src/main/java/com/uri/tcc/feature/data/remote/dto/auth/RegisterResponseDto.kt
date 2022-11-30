package com.uri.tcc.feature.data.remote.dto.auth

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.domain.model.auth.RegisterResponse
import java.io.Serializable

data class RegisterResponseDto(
    @SerializedName(value = "message") val message: String?
) : Serializable {

    val response: RegisterResponse
        get() = RegisterResponse(
            message = message ?: ""
        )
}