package com.uri.tcc.feature.remote.dto.course

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.course.Course

data class CourseDto(
    @SerializedName(value = "idCurso") val id: Int?,
    @SerializedName(value = "nome") val name: String?,
    @SerializedName(value = "areacurso") val area: String?
) {

    val response: Course
        get() = Course(
            id = id ?: 0,
            name = name ?: "",
            area = area ?: ""
        )
}