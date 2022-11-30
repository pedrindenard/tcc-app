package com.uri.tcc.feature.domain.use_case.message

import com.uri.tcc.core.Resource
import com.uri.tcc.feature.data.repository.MessageRepository
import com.uri.tcc.feature.domain.model.message.MessageResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetMessageUseCase(private val repository: MessageRepository) {

    operator fun invoke(): Flow<Resource<MessageResponse>> {
        return repository.getMessages().map { response ->
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