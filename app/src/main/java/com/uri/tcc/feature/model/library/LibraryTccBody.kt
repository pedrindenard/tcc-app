package com.uri.tcc.feature.model.library

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LibraryTccBody(
    @SerializedName(value = "tituloTCC") val title: String
) : Serializable