package com.uri.tcc.utils

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.content.ContextCompat

object ViewExtension {

    fun ListPopupWindow.setBackgroundColor(@DrawableRes drawable: Int, context: Context) {
        setBackgroundDrawable(ContextCompat.getDrawable(context, drawable))
    }
}