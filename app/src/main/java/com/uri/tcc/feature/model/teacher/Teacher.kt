package com.uri.tcc.feature.model.teacher

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.course.Course
import com.uri.tcc.feature.model.student.StudentTcc
import java.io.Serializable

data class Teacher(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "coordenador") val advisor: Boolean,
    @SerializedName(value = "cpf") val legalDocument: String,
    @SerializedName(value = "datanasc") val birthDate: String,
    @SerializedName(value = "descricaoPessoal") val description: String,
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "nome") val name: String,
    @SerializedName(value = "cursos") val course: List<Course>,
    @SerializedName(value = "tccs") val tcc: List<StudentTcc>
) : Serializable