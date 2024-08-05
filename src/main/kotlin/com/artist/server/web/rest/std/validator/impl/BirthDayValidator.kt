package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.BirthDay
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class BirthDayValidator : ConstraintValidator<BirthDay, String> {
    private lateinit var delimiter: Array<String>

    override fun initialize(constraintAnnotation: BirthDay) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val birthDay: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        val reg = Regex("^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\$")

        return birthDay.matches(reg)
    }
}
