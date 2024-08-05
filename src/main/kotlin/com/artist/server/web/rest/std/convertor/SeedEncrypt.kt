package com.artist.server.web.rest.std.convertor

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SeedEncrypt(
    val isEncrypt: Boolean,
    val maskingStartIndex: Int = -1,
    val maskingEndIndex: Int = -1,
    val maskingChar: Char = '*'
)
