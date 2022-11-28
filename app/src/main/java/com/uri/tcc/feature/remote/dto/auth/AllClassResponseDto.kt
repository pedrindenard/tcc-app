package com.uri.tcc.feature.remote.dto.auth

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.AllClassResponse
import com.uri.tcc.feature.model.ClassArea
import java.io.Serializable

data class AllClassResponseDto(
    @SerializedName(value = "id") val id: String?,
    @SerializedName(value = "name") val name: String?,
    @SerializedName(value = "classArea") val classArea: ClassAreaDto?
) : Serializable {

    data class ClassAreaDto(
        @SerializedName(value = "name") val name: String?,
        @SerializedName(value = "id") val id: String?
    ) : Serializable {

        val response: ClassArea
            get() = ClassArea(
                name = name ?: "",
                id = id ?: ""
            )
    }

    val response: AllClassResponse
        get() = AllClassResponse(
            id = id ?: "",
            name = name ?: "",
            classArea = classArea?.response
        )
}