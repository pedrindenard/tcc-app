package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceObjComment(
    @SerializedName("comentarios") val comments: List<GuidanceComment>?
) : Serializable