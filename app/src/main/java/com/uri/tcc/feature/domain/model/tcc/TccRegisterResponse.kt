package com.uri.tcc.feature.domain.model.tcc

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TccRegisterResponse(
    @SerializedName(value = "data") val data: TccData?
) : Serializable