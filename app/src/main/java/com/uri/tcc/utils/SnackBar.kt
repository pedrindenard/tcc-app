package com.uri.tcc.utils

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

object SnackBar {

    fun Activity.createSnackBarInActivity(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).apply {
            setBackgroundTint(Color.GRAY)

            val text = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val params = view.layoutParams

            when (params) {
                is CoordinatorLayout.LayoutParams -> params.gravity = Gravity.TOP
                is FrameLayout.LayoutParams -> params.gravity = Gravity.TOP
            }

            text.setTextColor(Color.WHITE)
            text.textAlignment = View.TEXT_ALIGNMENT_CENTER

            view.layoutParams = params
            show()
        }
    }

    fun View.createSnackBarInFragment(message: String) {
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).apply {
            setBackgroundTint(Color.GRAY)

            val text = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val params = view.layoutParams

            when (params) {
                is CoordinatorLayout.LayoutParams -> params.gravity = Gravity.TOP
                is FrameLayout.LayoutParams -> params.gravity = Gravity.TOP
            }

            text.setTextColor(Color.WHITE)
            text.textAlignment = View.TEXT_ALIGNMENT_CENTER

            view.layoutParams = params
            show()
        }
    }
}