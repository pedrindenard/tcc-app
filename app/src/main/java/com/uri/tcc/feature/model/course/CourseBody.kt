package com.uri.tcc.feature.model.course

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CourseBody(
    @SerializedName(value = "idCurso") val id: Int,
    @SerializedName(value = "nome") val name: String,
    @SerializedName(value = "areacurso") val area: String,
    @SerializedName(value = "alunos") val students: List<PeopleBody>,
    @SerializedName(value = "professores") val teachers: List<PeopleBody>
) : Serializable {

    data class PeopleBody(
        @SerializedName(value = "id") val id: Int,
        @SerializedName(value = "arquivo") val archive: ArchiveBody,
        @SerializedName(value = "cpf") val legalDocument: String,
        @SerializedName(value = "curso") val course: String,
        @SerializedName(value = "datanasc") val birthDate: String,
        @SerializedName(value = "descricaoPessoal") val description: String,
        @SerializedName(value = "email") val email: String,
        @SerializedName(value = "nome") val name: String,
        @SerializedName(value = "notificacoes") val notification: List<NotificationBody>,
        @SerializedName(value = "orientacao") val orientation: GuidanceBody,
        @SerializedName(value = "senha") val password: String,
        @SerializedName(value = "tcc") val tcc: TccBody,
        @SerializedName(value = "tipoUsuario") val type: String,
        @SerializedName(value = "verificado") val verify: Boolean
    ) : Serializable

    data class TccBody(
        @SerializedName(value = "id") val id: Int,
        @SerializedName(value = "aluno") val student: String,
        @SerializedName(value = "arquivo") val archive: String,
        @SerializedName(value = "descricao") val description: String,
        @SerializedName(value = "notificacao") val notification: String,
        @SerializedName(value = "orientacao") val guidance: String,
        @SerializedName(value = "orientador") val advisor: String,
        @SerializedName(value = "titulo") val title: String
    ) : Serializable

    data class ArchiveBody(
        @SerializedName(value = "id") val id: Int,
        @SerializedName(value = "aluno") val student: String,
        @SerializedName(value = "biblioteca") val library: LibraryBody,
        @SerializedName(value = "data") val data: String,
        @SerializedName(value = "docName") val docName: String,
        @SerializedName(value = "docType") val docType: String,
        @SerializedName(value = "professor") val teacher: String,
        @SerializedName(value = "tcc") val tcc: TccBody
    ) : Serializable

    data class LibraryBody(
        @SerializedName(value = "id") val id: Int,
        @SerializedName(value = "arquivo") val archive: String,
        @SerializedName(value = "descricaoTCC") val description: String,
        @SerializedName(value = "nomeAluno") val student: String,
        @SerializedName(value = "nomeCurso") val course: String,
        @SerializedName(value = "nomeOrientador") val advisor: String,
        @SerializedName(value = "tituloTCC") val title: String
    ) : Serializable

    data class NotificationBody(
        @SerializedName(value = "aluno") val student: String,
        @SerializedName(value = "confirmada") val confirmed: Boolean,
        @SerializedName(value = "dataConfirmacao") val dateConfirm: String,
        @SerializedName(value = "dataNotificacao") val dateNotification: String,
        @SerializedName(value = "dataOrientacao") val dataGuidance: DataGuidanceBody,
        @SerializedName(value = "descartada") val discarded: Boolean,
        @SerializedName(value = "idNotificacao") val notificationId: Int,
        @SerializedName(value = "orientacao") val guidance: GuidanceBody,
        @SerializedName(value = "professor") val teacher: String,
        @SerializedName(value = "tcc") val tcc: TccBody,
        @SerializedName(value = "tipoNotificacao") val notificationTyped: String,
    )

    data class DataGuidanceBody(
        @SerializedName(value = "id") val id: Int,
        @SerializedName(value = "dataOrientacao") val date: String,
        @SerializedName(value = "notificacao") val notification: String,
        @SerializedName(value = "orientacao") val guidance: String,
    )

    data class GuidanceBody(
        @SerializedName(value = "aluno") val student: String,
        @SerializedName(value = "comentarios") val comments: List<CommentBody>,
        @SerializedName(value = "datasOrientacoes") val data: List<AdvisorBody>,
        @SerializedName(value = "idOrientacao") val id: Int,
        @SerializedName(value = "notificacao") val notification: String,
        @SerializedName(value = "professor") val teacher: String,
        @SerializedName(value = "tcc") val tcc: TccBody,
        @SerializedName(value = "tituloTCC") val tccTitle: String
    )

    data class CommentBody(
        @SerializedName(value = "autor") val author: String,
        @SerializedName(value = "comentario") val comment: String,
        @SerializedName(value = "dataComentario") val date: String,
        @SerializedName(value = "idComentario") val id: Int,
        @SerializedName(value = "orientacao") val guidance: String
    )

    data class AdvisorBody(
        @SerializedName(value = "dataOrientacao") val author: String,
        @SerializedName(value = "orientacao") val comment: String,
        @SerializedName(value = "notificacao") val date: String,
        @SerializedName(value = "id") val id: Int
    )
}