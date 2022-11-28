package com.uri.tcc.feature.remote.dto.student

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.student.Student
import com.uri.tcc.feature.model.student.StudentTcc

data class StudentDto(
    @SerializedName(value = "cpf") val legalDocument: String?,
    @SerializedName(value = "datanasc") val birthDate: String?,
    @SerializedName(value = "descricaoPessoal") val description: String?,
    @SerializedName(value = "email") val email: String?,
    @SerializedName(value = "id") val id: Int?,
    @SerializedName(value = "idCurso") val idCourse: Int?,
    @SerializedName(value = "nome") val name: String?,
    @SerializedName(value = "nomeCurso") val nameCourse: String?,
    @SerializedName(value = "tccAlunoDTO") val tcc: TccDto?
) {

    data class TccDto(
        @SerializedName(value = "idProfessor") val idTeacher: Int?,
        @SerializedName(value = "idTCC") val idTcc: Int?,
        @SerializedName(value = "descricao") val description: String?,
        @SerializedName(value = "nomeProfessor") val teacher: String?,
        @SerializedName(value = "titulo") val title: String?
    ) {
        val response: StudentTcc
            get() = StudentTcc(
                idTeacher = idTeacher ?: 0,
                idTcc = idTcc ?: 0,
                description = description ?: "",
                nameTeacher = teacher ?: "",
                title = title ?: ""
            )
    }

    val response: Student
        get() = Student(
            legalDocument = legalDocument ?: "",
            birthDate = birthDate ?: "",
            description = description ?: "",
            email = email ?: "",
            id = id ?: 0,
            idCourse = idCourse ?: 0,
            name = name ?: "",
            nameCourse = nameCourse ?: "",
            tcc = tcc?.response
        )
}