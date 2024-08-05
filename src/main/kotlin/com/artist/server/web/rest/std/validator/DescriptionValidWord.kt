package com.artist.server.web.rest.std.validator

import com.artist.server.web.rest.std.validator.impl.DescriptionValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DescriptionValidator::class])
annotation class DescriptionValidWord(
    val message: String = "{DescriptionValidWord}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val invalidWord: Array<String> = []
)
