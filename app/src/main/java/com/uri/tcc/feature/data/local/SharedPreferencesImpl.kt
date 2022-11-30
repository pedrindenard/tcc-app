package com.uri.tcc.feature.data.local

import android.content.Context
import com.uri.tcc.BuildConfig

class SharedPreferencesImpl(context: Context) : SharedPreferences {

    private val preferencesFilename = BuildConfig.APPLICATION_ID

    private val sharedPreferences = context.getSharedPreferences(preferencesFilename, 0)

    override fun insert(value: String, key: String) { sharedPreferences.edit().putString(key, value).apply() }

    override fun get(key: String): String? = sharedPreferences.getString(key, "")

    override fun remove(key: String) { sharedPreferences.edit().remove(key).apply() }

    object Setting {
        const val USER_LOGIN = "user.login"
        const val USER_TOKEN = "user.token"
    }
}