package com.artist.server.web.rest.std.convertor

import com.artist.server.security.SeedUtils
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.stereotype.Component
import java.lang.reflect.Field

@Component
class SeedJsonSerializer(
    private val seedUtils: SeedUtils,
) : JsonSerializer<Any>() {

    override fun serialize(value: Any, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        value::class.java.declaredFields.forEach { field ->
            gen.writeFieldName(field.name)
            field.isAccessible = true
            val seedEncryptAnnotation = field.getDeclaredAnnotation(SeedEncrypt::class.java)
            gen.writeObject(generateFieldValue(field, value, seedEncryptAnnotation))
        }
        gen.writeEndObject()
    }

    /**
     * 직렬화시 필드 값 설정하는 로직
     */
    private fun generateFieldValue(field: Field, value: Any, seedEncrypt: SeedEncrypt?): Any {
        if (field.get(value)::class == String::class && seedEncrypt != null)
            return convertValue(field.get(value).toString(), seedEncrypt)

        return field.get(value)
    }

    /**
     * 어노테이션 값에 따라 암,복호화 하는 로직
     */
    private fun convertValue(value: String, annotation: SeedEncrypt): String {
        return if (annotation.isEncrypt) seedUtils.encode(value) else decode(annotation, value)
    }

    /**
     * 복호화 하는 로직
     */
    private fun decode(annotation: SeedEncrypt, value: String): String {
        val decodeValue = seedUtils.decode(value)

        val maskingStartIndex = annotation.maskingStartIndex
        val maskingEndIndex = annotation.maskingEndIndex

        val replaceRange =
            if (maskingStartIndex < 0 || maskingStartIndex > maskingEndIndex || decodeValue.length <= maskingEndIndex)
                IntRange(0, decodeValue.length - 1)
            else IntRange(maskingStartIndex, maskingEndIndex)

        val maskingValue = annotation.maskingChar.toString().repeat(replaceRange.count())

        return decodeValue.replaceRange(replaceRange, maskingValue)
    }
}
