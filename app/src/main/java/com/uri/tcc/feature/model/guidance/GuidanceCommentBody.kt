package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceCommentBody(
    @SerializedName(value = "comentario") val comment: String
) : Serializable