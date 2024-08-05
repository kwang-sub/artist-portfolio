package com.artist.server.service.std.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.core.StdCommonGroupCode] entity.
 */
@Schema(description = "공통그룹코드")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class CommonGroupCodeReqDTO(

    var id: Long? = null,

    /**
     * 공통그룹코드
     */
    @get: NotNull
    @get: NotBlank
    @get: Size(max = 25)
    @field: NotNull
    @Schema(description = "공통그룹코드", required = true)
    var commonGroupCode: String? = null,

    /**
     * 공통그룹코드명
     */
    @get: NotNull
    @get: NotBlank
    @get: Size(max = 50)
    @field: NotNull
    @Schema(description = "공통그룹코드명", required = true)
    var commonGroupCodeName: String? = null,

    /**
     * 공통그룹코드설명
     */
    @get: Size(max = 255)
    @Schema(description = "공통그룹코드설명")
    var commonGroupCodeDesc: String? = null,

    /**
     * 정렬순서
     */
    @get: NotNull
    @field: NotNull
    @Schema(description = "정렬순서", required = true)
    var sortNum: Int? = null,

    /**
     * 활성화여부
     */
    @get: NotNull
    @field: NotNull
    @Schema(description = "활성화여부", required = true)
    var isActivated: Boolean? = null,

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CommonGroupCodeReqDTO) return false
        if (this.id == null) {
            return false
        }
        return Objects.equals(this.id, other.id)
    }

    override fun hashCode() = Objects.hash(this.id)
}
