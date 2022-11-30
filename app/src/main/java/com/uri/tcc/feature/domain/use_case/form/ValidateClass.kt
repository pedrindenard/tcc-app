package com.uri.tcc.feature.domain.use_case.form

import com.uri.tcc.R
import com.uri.tcc.feature.domain.model.form.UIText
import com.uri.tcc.feature.domain.model.form.ValidationResult

class ValidateClass {

    fun execute(classId: String): ValidationResult {
        if (classId.isBlank()) {
            return ValidationResult(false, UIText.StringResource(R.string.message_class_id_empty))
        }

        return ValidationResult(true, UIText.StringResource(R.string.no_message_available))
    }
}