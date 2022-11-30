package com.uri.tcc.feature.data.remote.network

import com.uri.tcc.feature.data.remote.dto.auth.AllClassResponseDto
import com.uri.tcc.feature.data.remote.dto.auth.LoginResponseDto
import com.uri.tcc.feature.data.remote.dto.auth.RegisterResponseDto
import com.uri.tcc.feature.data.remote.dto.auth.ResetPasswordResponseDto
import com.uri.tcc.feature.data.remote.dto.message.MessageChangedDto
import com.uri.tcc.feature.data.remote.dto.message.MessageResponseDto
import com.uri.tcc.feature.data.remote.dto.tcc.TccRegisterResponseDto
import com.uri.tcc.feature.domain.body.auth.LoginBody
import com.uri.tcc.feature.domain.body.auth.RegisterBody
import com.uri.tcc.feature.domain.body.auth.ResetPasswordBody
import com.uri.tcc.feature.domain.body.message.MessageEditBody
import com.uri.tcc.feature.domain.body.message.MessageSendBody
import com.uri.tcc.feature.domain.body.tcc.TccRegisterBody
import com.uri.tcc.feature.domain.body.tcc.TccUpdateBody
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
    @GET(value = "api/v1/class/getAllClasses")
    suspend fun getAllClasses(): Response<List<AllClassResponseDto>>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "api/v1/tcc/create")
    suspend fun doRegisterTcc(@Body body: TccRegisterBody): Response<TccRegisterResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "api/v1/tcc/update")
    suspend fun doUpdateTcc(@Body body: TccUpdateBody): Response<TccRegisterResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @GET(value = "api/v1/messages/getMessages")
    suspend fun getMessages(@Query(value = "guidanceId") query: String): Response<MessageResponseDto>

    @Headers(value = ["Content-Type: application/json"])
    @POST(value = "api/v1/messages/sendMessage")
    suspend fun doSendMessage(@Body body: MessageSendBody): Response<MessageChangedDto>

    @Headers(value = ["Content-Type: application/json"])
    @PUT(value = "api/v1/messages/editMessage")
    suspend fun doUpdateMessage(@Body body: MessageEditBody): Response<MessageChangedDto>

//    @Headers(value = [""])
//    @GET(value = "")
//    suspend fun a(): Response<>
}