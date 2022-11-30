package com.uri.tcc.feature.domain.use_case.auth

import com.uri.tcc.core.Resource
import com.uri.tcc.feature.data.repository.UserRepository
import com.uri.tcc.feature.domain.body.auth.ResetPasswordBody
import com.uri.tcc.feature.domain.model.auth.ResetPasswordResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DoResetPasswordUseCase(private val repository: UserRepository) {

    operator fun invoke(body: ResetPasswordBody): Flow<Resource<ResetPasswordResponse>> {
        return repository.doResetPassword(body).map { response ->
            if (response.isSuccessful) {
                Resource.Success(response.body()!!.response)
            } else {
                Resource.Error(response.message())
            }
        }.catch { exception ->
            emit(Resource.Failure(exception))
        }
    }
}