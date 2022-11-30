package com.uri.tcc.feature.domain.use_case.form

import com.uri.tcc.R
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.form.ValidationResult

class ValidateName {

    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_name_empty))
        }

        if (name.length < 3) {
            return ValidationResult(false, UIText.StringResource(R.string.message_name_invalid))
        }

        return ValidationResult(true, UIText.StringResource(R.string.no_message_available))
    }
}