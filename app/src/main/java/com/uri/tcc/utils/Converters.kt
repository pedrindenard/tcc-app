package com.uri.tcc.utils

import com.google.gson.Gson

object Converters {

    fun Any.toJson(): String = Gson().toJson(this)

    inline fun <reified T> String?.fromJsonTo(): T? = Gson().fromJson(this, T::class.java)
}