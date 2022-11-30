package com.uri.tcc.feature.data.remote.dto.auth

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.domain.model.auth.LoginGuidance
import com.uri.tcc.feature.domain.model.auth.LoginResponse
import com.uri.tcc.feature.domain.model.auth.LoginStudent
import com.uri.tcc.feature.domain.model.auth.LoginTcc
import java.io.Serializable

data class LoginResponseDto(
    @SerializedName(value = "token") val token: String?,
    @SerializedName(value = "id") val id: String?,
    @SerializedName(value = "guidance") val guidance: List<LoginGuidanceDto>?
) : Serializable {

    data class LoginGuidanceDto(
        @SerializedName(value = "id") val id: String?,
        @SerializedName(value = "tcc") val tcc: LoginTccDto?
    ) : Serializable {

        data class LoginTccDto(
            @SerializedName(value = "title") val title: String?,
            @SerializedName(value = "student") val student: LoginStudentDto?
        ) : Serializable {

            data class LoginStudentDto(
                @SerializedName(value = "id") val id: String?,
                @SerializedName(value = "name") val name: String?
            ) : Serializable {

                val response: LoginStudent
                    get() = LoginStudent(
                        id = id ?: "",
                        name = name ?: ""
                    )
            }

            val response: LoginTcc
                get() = LoginTcc(
                    title = title ?: "",
                    student = student?.response
                )
        }

        val response: LoginGuidance
            get() = LoginGuidance(
                id = id ?: "",
                tcc = tcc?.response
            )
    }

    val response: LoginResponse
        get() = LoginResponse(
            guidance = guidance?.map { it.response } ?: emptyList(),
            token = token ?: "",
            id = id ?: ""
        )
}