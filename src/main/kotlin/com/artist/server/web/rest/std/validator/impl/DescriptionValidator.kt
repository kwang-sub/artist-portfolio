package com.artist.server.web.rest.std.validator.impl

import com.artist.server.web.rest.std.validator.DescriptionValidWord
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class DescriptionValidator : ConstraintValidator<DescriptionValidWord, String> {
    private lateinit var invalidWord: Array<String>
    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        if (value == null) {
            return true
        }

        return invalidWord.find {
            value.contains(it)
        } == null
    }

    override fun initialize(constraintAnnotation: DescriptionValidWord) {
        invalidWord = constraintAnnotation.invalidWord
    }
}
