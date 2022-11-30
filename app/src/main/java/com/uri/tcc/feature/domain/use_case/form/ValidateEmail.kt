package com.uri.tcc.feature.domain.use_case.form

import android.util.Patterns
import com.uri.tcc.R
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.form.ValidationResult

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_email_empty))
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_email_invalid))
        }

        return ValidationResult(true, UIText.StringResource(R.string.no_message_available))
    }
}