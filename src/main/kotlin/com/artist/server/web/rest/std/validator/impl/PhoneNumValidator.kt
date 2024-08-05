package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.PhoneNum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PhoneNumValidator : ConstraintValidator<PhoneNum, String> {
    private lateinit var delimiter: Array<String>

    override fun initialize(constraintAnnotation: PhoneNum) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val phoneNum: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        if (phoneNum.length != 11) return false
        val reg = Regex("^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})\$")

        return phoneNum.matches(reg)
    }
}
