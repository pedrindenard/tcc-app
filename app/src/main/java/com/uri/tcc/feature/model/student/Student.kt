package com.uri.tcc.feature.model.student

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Student(
    @SerializedName(value = "cpf") val legalDocument: String,
    @SerializedName(value = "datanasc") val birthDate: String,
    @SerializedName(value = "descricaoPessoal") val description: String,
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "idCurso") val idCourse: Int,
    @SerializedName(value = "nome") val name: String,
    @SerializedName(value = "nomeCurso") val nameCourse: String,
    @SerializedName(value = "tccAlunoDTO") val tcc: StudentTcc?
): Serializable