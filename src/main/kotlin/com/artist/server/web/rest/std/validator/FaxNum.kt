package com.artist.server.web.rest.std.validator

import com.artist.server.web.rest.std.validator.impl.FaxNumValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [FaxNumValidator::class])
annotation class FaxNum(
    val message: String = "올바르지 않은 팩스번호입니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val delimiter: Array<String> = [],
)
