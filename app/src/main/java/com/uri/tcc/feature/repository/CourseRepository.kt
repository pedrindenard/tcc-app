package com.uri.tcc.feature.repository

import com.uri.tcc.feature.model.course.CourseBody
import com.uri.tcc.feature.remote.dto.course.CourseDto
import com.uri.tcc.feature.remote.network.CourseApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class CourseRepository(private val api: CourseApi) {

    fun addCourse(course: CourseBody): Flow<Response<CourseDto>> =
        flow { emit(api.addCourse(course)) }.flowOn(Dispatchers.IO)

    fun getCourse(): Flow<Response<CourseDto>> =
        flow { emit(api.getCourse()) }.flowOn(Dispatchers.IO)
}