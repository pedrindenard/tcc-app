package com.uri.tcc.feature.domain.use_case.form

import com.uri.tcc.R
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.form.ValidationResult

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.isBlank()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_password_empty))
        }

        if (password.length < 5) {
            return ValidationResult(false, UIText.StringResource(R.string.message_password_invalid))
        }

        return ValidationResult(true, UIText.StringResource(R.string.no_message_available))
    }
}