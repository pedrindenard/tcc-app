package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccDocument(
    @SerializedName(value = "description") val description: String,
    @SerializedName(value = "file") val file: TccFile?,
    @SerializedName(value = "filename") val filename: String,
    @SerializedName(value = "inputStream") val inputStream: Any?,
    @SerializedName(value = "open") val open: Boolean,
    @SerializedName(value = "readable") val readable: Boolean,
    @SerializedName(value = "uri") val uri: TccUri?,
    @SerializedName(value = "url") val url: TccUrl?
) : Serializable