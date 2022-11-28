package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccFile(
    @SerializedName(value = "absolute") val absolute: Boolean,
    @SerializedName(value = "absoluteFile") val absoluteFile: String,
    @SerializedName(value = "absolutePath") val absolutePath: String,
    @SerializedName(value = "canonicalFile") val canonicalFile: String,
    @SerializedName(value = "canonicalPath") val canonicalPath: String,
    @SerializedName(value = "directory") val directory: Boolean,
    @SerializedName(value = "executable") val executable: Boolean,
    @SerializedName(value = "file") val file: Boolean,
    @SerializedName(value = "freeSpace") val freeSpace: Float,
    @SerializedName(value = "hidden") val hidden: Boolean,
    @SerializedName(value = "lastModified") val lastModified: Float,
    @SerializedName(value = "name") val name: String,
    @SerializedName(value = "parent") val parent: String,
    @SerializedName(value = "parentFile") val parentFile: String,
    @SerializedName(value = "path") val path: String,
    @SerializedName(value = "readable") val readable: Boolean,
    @SerializedName(value = "totalSpace") val totalSpace: Float,
    @SerializedName(value = "usableSpace") val usableSpace: Float,
    @SerializedName(value = "writable") val writable: Boolean
) : Serializable