package com.uri.tcc.feature.model.teacher

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeacherBody(
    @SerializedName(value = "cpf") val legalDocument: String,
    @SerializedName(value = "cursoId") val courseId: String,
    @SerializedName(value = "datanasc") val birthDate: String,
    @SerializedName(value = "descricaoPessoal") val description: String,
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "nome") val name: String,
    @SerializedName(value = "senha") val password: String,
    @SerializedName(value = "tipoUsuario") val type: String
) : Serializable