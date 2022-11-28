package com.uri.tcc.feature.remote.dto.tcc

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.TccData
import com.uri.tcc.feature.model.TccRegisterResponse
import java.io.Serializable

data class TccRegisterResponseDto(
    @SerializedName(value = "data") val data: TccDataDto?
) : Serializable {

    data class TccDataDto(
        @SerializedName(value = "id") val id: String?,
        @SerializedName(value = "title") val title: String?,
        @SerializedName(value = "summary") val summary: String?,
        @SerializedName(value = "classId") val classId: String?,
        @SerializedName(value = "studentId") val studentId: String?,
        @SerializedName(value = "teacherId") val teacherId: String?,
        @SerializedName(value = "guidanceId") val guidanceId: String?,
        @SerializedName(value = "docFileLink") val docFileLink: String?,
        @SerializedName(value = "status") val status: String?
    ) : Serializable {

        val response: TccData
            get() = TccData(
                id = id ?: "",
                title = title ?: "",
                summary = summary ?: "",
                classId = classId ?: "",
                studentId = studentId ?: "",
                teacherId = teacherId ?: "",
                guidanceId = guidanceId ?: "",
                docFileLink = docFileLink ?: "",
                status = status ?: ""
            )
    }

    val response: TccRegisterResponse
        get() = TccRegisterResponse(
            data = data?.response
        )
}