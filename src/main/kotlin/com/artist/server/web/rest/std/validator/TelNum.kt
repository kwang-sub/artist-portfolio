package com.artist.server.web.rest.std.validator

import com.artist.server.web.rest.std.validator.impl.TelNumValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [TelNumValidator::class])
annotation class TelNum(
    val message: String = "올바르지 않은 연락처입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val delimiter: Array<String> = [],
)
