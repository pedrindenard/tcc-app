package com.uri.tcc.utils

import android.text.Editable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object StringFormat {

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    fun String.formatToDate(): String {
        return if (isNotEmpty() && isNotBlank()) {
            try {
                val formatter: DateFormat = SimpleDateFormat("yyyy-MM-DD", Locale.ROOT)
                val date = formatter.parse(this) as Date
                DateFormat.getDateInstance(DateFormat.LONG).format(date)
            } catch (e: Exception) {
                this
            }
        } else {
            this
        }
    }
}