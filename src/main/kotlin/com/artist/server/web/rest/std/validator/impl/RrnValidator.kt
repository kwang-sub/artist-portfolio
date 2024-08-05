package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.Rrn
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class RrnValidator : ConstraintValidator<Rrn, String> {
    private lateinit var delimiter: Array<String>

    override fun initialize(constraintAnnotation: Rrn) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val rrn: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        if (rrn.length != 13) return false
        val reg = Regex("^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])[1-4][0-9]{6}$")

        return rrn.matches(reg)
    }
}
