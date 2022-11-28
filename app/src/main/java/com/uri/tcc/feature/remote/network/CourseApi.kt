package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.model.course.CourseBody
import com.uri.tcc.feature.remote.dto.course.CourseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CourseApi {

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "curso/add")
    suspend fun addCourse(@Body course: CourseBody): Response<CourseDto>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "curso/getCursos")
    suspend fun getCourse(): Response<CourseDto>
}