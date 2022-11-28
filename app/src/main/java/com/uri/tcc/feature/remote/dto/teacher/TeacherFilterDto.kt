package com.uri.tcc.feature.remote.dto.teacher

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.teacher.TeacherFilter

data class TeacherFilterDto(
    @SerializedName(value = "id") val id: Int?,
    @SerializedName(value = "nome") val name: String?
) {
    val response: TeacherFilter
        get() = TeacherFilter(
            id = id ?: 0,
            name = name ?: ""
        )
}