package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccUri(
    @SerializedName(value = "absolute") val absolute: Boolean,
    @SerializedName(value = "authority") val authority: String,
    @SerializedName(value = "fragment") val fragment: String,
    @SerializedName(value = "host") val host: String,
    @SerializedName(value = "opaque") val opaque: Boolean,
    @SerializedName(value = "path") val path: String,
    @SerializedName(value = "port") val port: Float,
    @SerializedName(value = "query") val query: String,
    @SerializedName(value = "rawAuthority") val rawAuthority: String,
    @SerializedName(value = "rawFragment") val rawFragment: String,
    @SerializedName(value = "rawPath") val rawPath: String,
    @SerializedName(value = "rawQuery") val rawQuery: String,
    @SerializedName(value = "rawSchemeSpecificPart") val rawSchemeSpecificPart: String,
    @SerializedName(value = "rawUserInfo") val rawUserInfo: String,
    @SerializedName(value = "scheme") val scheme: String,
    @SerializedName(value = "schemeSpecificPart") val schemeSpecificPart: String,
    @SerializedName(value = "userInfo") val userInfo: String
) : Serializable