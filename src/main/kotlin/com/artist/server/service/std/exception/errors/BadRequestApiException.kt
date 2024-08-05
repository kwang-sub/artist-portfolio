package com.artist.server.service.std.exception.errors

import org.zalando.problem.AbstractThrowableProblem
import org.zalando.problem.Exceptional
import org.zalando.problem.Status

@SuppressWarnings("java:S110") // Inheritance tree of classes should not be too deep
open class BadRequestApiException(message: String, val errorKey: String) :
    AbstractThrowableProblem(
        null, null, Status.BAD_REQUEST, null, null, null,
        getAlertParameters(message)
    ) {

    override fun getCause(): Exceptional? = super.cause

    companion object {

        private const val serialVersionUID = 1L

        private fun getAlertParameters(message: String) =
            mutableMapOf<String, Any>(
                "message" to message
            )
    }
}
