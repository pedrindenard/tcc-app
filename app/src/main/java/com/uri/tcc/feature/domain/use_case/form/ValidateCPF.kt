package com.uri.tcc.feature.domain.use_case.form

import com.uri.tcc.R
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.form.ValidationResult

class ValidateCPF {

    fun execute(cpf: String): ValidationResult {
        if (cpf.isBlank()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_cpf_empty))
        }

        if (cpf.length != 11) {
            return ValidationResult(false, UIText.StringResource(R.string.message_cpf_invalid))
        }

        return ValidationResult(true, UIText.StringResource(R.string.no_message_available))
    }
}