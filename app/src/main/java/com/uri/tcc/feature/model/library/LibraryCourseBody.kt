package com.uri.tcc.feature.model.library

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LibraryCourseBody(
    @SerializedName(value = "nomeCurso") val course: String
) : Serializable
