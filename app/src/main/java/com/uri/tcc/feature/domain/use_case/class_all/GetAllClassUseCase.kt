package com.uri.tcc.feature.domain.use_case.class_all

import com.uri.tcc.core.Resource
import com.uri.tcc.feature.data.repository.ClassAllRepository
import com.uri.tcc.feature.domain.model.library.AllClassResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetAllClassUseCase(private val repository: ClassAllRepository) {

    operator fun invoke(): Flow<Resource<List<AllClassResponse>>> {
        return repository.getAllClass().map { response ->
            if (response.isSuccessful) {
                Resource.Success(response.body()!!.map { it.response })
            } else {
                Resource.Error(response.message())
            }
        }.catch { exception ->
            emit(Resource.Failure(exception))
        }
    }
}