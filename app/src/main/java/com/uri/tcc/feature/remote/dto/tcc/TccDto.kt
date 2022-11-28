package com.uri.tcc.feature.remote.dto.tcc

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.tcc.Tcc
import com.uri.tcc.feature.model.tcc.TccPeople

data class TccDto(
    @SerializedName(value = "id") val id: Int?,
    @SerializedName(value = "docId") val docId: Int?,
    @SerializedName(value = "titulo") val title: String?,
    @SerializedName(value = "descricao") val description: String?,
    @SerializedName(value = "alunoDTO") val student: TccPeopleDto?,
    @SerializedName(value = "professor") val teacher: TccPeopleDto?
) {

    data class TccPeopleDto(
        @SerializedName(value = "id") val id: Int?,
        @SerializedName(value = "nome") val name: String?,
    ) {
        val response: TccPeople
            get() = TccPeople(
                id = id ?: 0,
                name = name ?: ""
            )
    }

    val response: Tcc
        get() = Tcc(
            id = id ?: 0,
            docId = docId ?: 0,
            title = title ?: "",
            description = description ?: "",
            student = student?.response,
            teacher = teacher?.response
        )
}