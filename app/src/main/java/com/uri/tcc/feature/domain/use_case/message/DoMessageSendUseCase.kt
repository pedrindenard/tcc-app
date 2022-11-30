package com.uri.tcc.feature.domain.use_case.message

import com.uri.tcc.core.Resource
import com.uri.tcc.feature.data.repository.MessageRepository
import com.uri.tcc.feature.domain.model.message.MessageChanged
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DoMessageSendUseCase(private val repository: MessageRepository) {

    operator fun invoke(text: String): Flow<Resource<MessageChanged>> {
        return repository.doSendMessage(text).map { response ->
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