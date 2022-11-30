package com.uri.tcc.core

sealed class Resource<out T> {

    class Loading<out T>(val isLoading: Boolean) : Resource<T>()

    class Failure<out T>(val throwable: Throwable) : Resource<T>()

    class Error<out T>(val message: String) : Resource<T>()

    class Success<out T>(val data: T) : Resource<T>()
}