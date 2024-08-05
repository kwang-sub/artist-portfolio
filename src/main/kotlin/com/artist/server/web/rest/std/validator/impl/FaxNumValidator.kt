package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.FaxNum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class FaxNumValidator : ConstraintValidator<FaxNum, String> {
    private lateinit var delimiter: Array<String>

    override fun initialize(constraintAnnotation: FaxNum) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val faxNum: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        val reg = Regex("^\\d{2,3}\\d{3,4}\\d{4}\$")

        return faxNum.matches(reg)
    }
}
