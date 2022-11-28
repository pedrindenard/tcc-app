package com.uri.tcc.feature.model.guidance

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GuidanceComment(
    @SerializedName("autor") val author: String,
    @SerializedName("comentario") val comment: String,
    @SerializedName("dataComentario") val commentDate: String,
    @SerializedName("idComentario") val commentId: Int?
) : Serializable