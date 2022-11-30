package com.uri.tcc.utils

import android.os.Handler
import android.os.Looper

object CountDownTimer {

    fun getDelayMillis(delayMillis: Long, block: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({ block() }, delayMillis)
    }
}