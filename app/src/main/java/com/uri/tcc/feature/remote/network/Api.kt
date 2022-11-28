package com.uri.tcc.feature.remote.network

import com.uri.tcc.feature.body.auth.LoginBody
import com.uri.tcc.feature.body.auth.RegisterBody
import com.uri.tcc.feature.body.auth.ResetPasswordBody
import com.uri.tcc.feature.body.tcc.TccRegisterBody
import com.uri.tcc.feature.remote.dto.auth.AllClassResponseDto
import com.uri.tcc.feature.remote.dto.auth.LoginResponseDto
import com.uri.tcc.feature.remote.dto.auth.RegisterResponseDto
import com.uri.tcc.feature.remote.dto.auth.ResetPasswordResponseDto
import com.uri.tcc.feature.remote.dto.tcc.TccRegisterResponseDto
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "api/v1/user/login")
    suspend fun doLogin(@Body body: LoginBody): Response<LoginResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "api/v1/user/create")
    suspend fun doRegister(@Body body: RegisterBody): Response<RegisterResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "api/v1/user/changePassword")
    suspend fun doResetPassword(@Body body: ResetPasswordBody): Response<ResetPasswordResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "api/v1/tcc/create")
    suspend fun doRegisterTcc(@Body body: TccRegisterBody): Response<TccRegisterResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "api/v1/class/getAllClasses")
    suspend fun getAllClasses(): Response<List<AllClassResponseDto>>
}