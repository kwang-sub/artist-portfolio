package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.TelNum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class TelNumValidator : ConstraintValidator<TelNum, String> {
    private lateinit var delimiter: Array<String>

    override fun initialize(constraintAnnotation: TelNum) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val telNum: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        val reg = Regex("^\\d{2,3}\\d{3,4}\\d{4}\$")

        return telNum.matches(reg)
    }
}
