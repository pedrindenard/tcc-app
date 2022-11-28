package com.uri.tcc.feature.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccPeople(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "nome") val name: String
) : Serializable