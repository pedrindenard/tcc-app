package com.uri.tcc.feature.remote.dto.teacher

import com.google.gson.annotations.SerializedName
import com.uri.tcc.feature.model.teacher.Teacher
import com.uri.tcc.feature.remote.dto.course.CourseDto
import com.uri.tcc.feature.remote.dto.student.StudentDto

data class TeacherDto(
    @SerializedName(value = "id") val id: Int?,
    @SerializedName(value = "coordenador") val advisor: Boolean?,
    @SerializedName(value = "cpf") val legalDocument: String?,
    @SerializedName(value = "datanasc") val birthDate: String?,
    @SerializedName(value = "descricaoPessoal") val description: String?,
    @SerializedName(value = "email") val email: String?,
    @SerializedName(value = "nome") val name: String?,
    @SerializedName(value = "cursos") val course: List<CourseDto>?,
    @SerializedName(value = "tccs") val tcc: List<StudentDto.TccDto>?
) {

    val response: Teacher
        get() = Teacher(
            id = id ?: 0,
            advisor = advisor ?: false,
            legalDocument = legalDocument ?: "",
            birthDate = birthDate ?: "",
            description = description ?: "",
            email = email ?: "",
            name = name ?: "",
            course = course?.map { it.response } ?: emptyList(),
            tcc = tcc?.map { it.response } ?: emptyList()
        )
}