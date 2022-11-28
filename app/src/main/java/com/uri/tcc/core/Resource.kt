package com.uri.tcc.core

sealed class Resource<out T> {

    class Loading<out T> : Resource<T>()

    class Failure<out T>(val throwable: Throwable) : Resource<T>()

    class Success<out T>(val data: T) : Resource<T>()

    class Empty<out T> : Resource<T>()
}