package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceBody(
    @SerializedName(value = "alunoId") val studentId: Int?,
    @SerializedName(value = "professorId") val teacherId: Int?
) : Serializable