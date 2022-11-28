package com.uri.tcc.feature.remote.interceptor

import android.content.ContentValues
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor

class Logger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        val objectMessage = message.startsWith(prefix = "{")
        val arrayMessage = message.startsWith(prefix = "[")

        if (objectMessage || arrayMessage) {
            try { var i = 0
                while (i < getPrettyJson(message).length) {
                    if (i + 1024 < getPrettyJson(message).length) {
                        Log.d(ContentValues.TAG, getJsonKbs(getPrettyJson(message), i))
                    } else {
                        Log.d(ContentValues.TAG, getJsonLength(getPrettyJson(message), i))
                    };  i += 1024
                }
            } catch (m: JsonSyntaxException) {
                Log.d(ContentValues.TAG, message)
            }
        } else {
            Log.d(ContentValues.TAG, message)
            return
        }
    }

    companion object {
        fun getPrettyJson(it: String): String {
            return GsonBuilder().setPrettyPrinting().create().toJson(getParseString(it))
        }

        fun getJsonLength(prettyPrintJson: String, i: Int): String {
            return prettyPrintJson.substring(i, prettyPrintJson.length)
        }

        fun getJsonKbs(prettyPrintJson: String, i: Int): String {
            return prettyPrintJson.substring(i, i + 1024)
        }

        private fun getParseString(it: String): JsonElement {
            return JsonParser.parseString(it)
        }
    }
}