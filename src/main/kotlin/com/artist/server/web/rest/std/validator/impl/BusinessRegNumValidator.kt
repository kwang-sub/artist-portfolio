package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.BusinessRegNum
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class BusinessRegNumValidator : ConstraintValidator<BusinessRegNum, String> {
    private lateinit var delimiter: Array<String>
    private val LOGIC_NUM = intArrayOf(1, 3, 7, 1, 3, 7, 1, 3, 5, 1)

    override fun initialize(constraintAnnotation: BusinessRegNum) {
        delimiter = constraintAnnotation.delimiter
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return true
        if (delimiter.contains("*")) return false
        val pattern = delimiter.joinToString(separator = "|")
        val regNum: String = if (delimiter.isNotEmpty()) value.replace(Regex(pattern), "") else value
        if (!isNumeric(regNum) || regNum.length != 10) return false

        var sum = 0
        var j: Int
        for (i in 0..8) {
            j = Character.getNumericValue(regNum[i])
            sum += j * LOGIC_NUM[i]
        }

        sum += (Character.getNumericValue(regNum[8]) * 5 / 10)

        val checkNum = (10 - sum % 10) % 10
        return checkNum == Character.getNumericValue(regNum[9])
    }

    fun isNumeric(str: String?): Boolean {
        if (str == null) {
            return false
        }
        val sz = str.length
        for (i in 0 until sz) {
            if (!Character.isDigit(str[i])) {
                return false
            }
        }
        return true
    }
}
