package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccUrl(
    @SerializedName(value = "authority") val authority: String,
    @SerializedName(value = "content") val content: Any?,
    @SerializedName(value = "defaultPort") val defaultPort: Float,
    @SerializedName(value = "file") val file: String,
    @SerializedName(value = "host") val host: String,
    @SerializedName(value = "path") val path: String,
    @SerializedName(value = "port") val port: Float,
    @SerializedName(value = "protocol") val protocol: String,
    @SerializedName(value = "query") val query: String,
    @SerializedName(value = "ref") val ref: String,
    @SerializedName(value = "userInfo") val userInfo: String
) : Serializable