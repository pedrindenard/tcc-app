package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.student.StudentBody
import com.uri.tcc.feature.model.student.StudentLoginBody
import com.uri.tcc.feature.remote.dto.student.StudentDto
import com.uri.tcc.feature.remote.dto.tcc.TccDocumentDto
import com.uri.tcc.feature.remote.dto.teacher.TeacherFilterDto
import com.uri.tcc.feature.remote.network.StudentApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import retrofit2.Response
import java.io.File

class StudentRepository(private val api: StudentApi) {

    fun doStudentLogin(student: StudentLoginBody): Flow<Response<StudentDto>> =
        flow { emit(api.doStudentLogin(student)) }.flowOn(Dispatchers.IO)

    fun getStudentByCourse(id: Int): Flow<Response<List<TeacherFilterDto>>> =
        flow { emit(api.getStudentByCourse(id)) }.flowOn(Dispatchers.IO)

    fun addStudent(student: StudentBody): Flow<Response<StudentDto>> =
        flow { emit(api.addStudent(student)) }.flowOn(Dispatchers.IO)

    fun updateStudent(id: Int, student: StudentBody): Flow<Response<StudentDto>> =
        flow { emit(api.updateStudent(id, student)) }.flowOn(Dispatchers.IO)

    fun deleteStudent(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteStudent(id)) }.flowOn(Dispatchers.IO)

    fun getStudent(id: Int): Flow<Response<StudentDto>> =
        flow { emit(api.getStudent(id)) }.flowOn(Dispatchers.IO)

    fun addDocument(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.addDocStudent(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun updateDocument(id: Int, file: File): Flow<Response<TccDocumentDto>> =
        flow { emit(api.updateDocStudent(id, MultipartBody.Part.createFormData("", ""))) }.flowOn(Dispatchers.IO)

    fun deleteDocument(id: Int): Flow<Response<Void>> =
        flow { emit(api.deleteDocStudent(id)) }.flowOn(Dispatchers.IO)

    fun getDocument(id: Int): Flow<Response<TccDocumentDto>> =
        flow { emit(api.getDocStudent(id)) }.flowOn(Dispatchers.IO)
}