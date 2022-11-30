package com.uri.tcc.feature.data.local

interface SharedPreferences {

    fun insert(value: String, key: String)

    fun get(key: String): String?

    fun remove(key: String)
}