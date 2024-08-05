package com.artist.server.service.std.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.core.StdCommonCode] entity.
 */
@Schema(description = "공통코드")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class CommonCodeResListDTO(
    /**
     * 공통코드 리스트
     */
    @get: NotNull
    @param: NotNull
    var commonCodeList: MutableList<CommonCodeResDTO>? = mutableListOf()
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CommonCodeResListDTO) return false
        if (this.commonCodeList == null) {
            return false
        }
        return Objects.equals(this.commonCodeList, other.commonCodeList)
    }

    override fun hashCode() = Objects.hash(this.commonCodeList)
}
