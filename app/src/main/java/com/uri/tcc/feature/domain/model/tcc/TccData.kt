package com.uri.tcc.feature.domain.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccData(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "summary") val summary: String,
    @SerializedName(value = "classId") val classId: String,
    @SerializedName(value = "studentId") val studentId: String,
    @SerializedName(value = "teacherId") val teacherId: String,
    @SerializedName(value = "guidanceId") val guidanceId: String,
    @SerializedName(value = "docFileLink") val docFileLink: String,
    @SerializedName(value = "status") val status: String
) : Serializable