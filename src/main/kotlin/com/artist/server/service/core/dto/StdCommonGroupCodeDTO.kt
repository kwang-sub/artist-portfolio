package com.artist.server.service.core.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.StdCommonGroupCode] entity.
 */
@Schema(description = "공통그룹코드")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdCommonGroupCodeDTO(

    var id: Long? = null,

    /**
     * 공통그룹코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Schema(description = "공통그룹코드", required = true)
    var commonGroupCode: String? = null,

    /**
     * 공통그룹코드명
     */
    @get: NotNull
    @get: Size(max = 50)
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
    @Schema(description = "정렬순서", required = true)
    var sortNum: Int? = null,

    /**
     * 활성화여부
     */
    @get: NotNull
    @Schema(description = "활성화여부", required = true)
    var isActivated: Boolean? = null,

    /**
     * 삭제여부
     */
    @get: NotNull
    @Schema(description = "삭제여부", required = true)
    var isDeleted: Boolean? = false,

    /**
     * 등록자ID
     */
    @get: NotNull
    @get: Size(max = 100)
    @Schema(description = "등록자ID", required = true)
    var createdBy: String? = "",

    /**
     * 등록일시
     */
    @get: NotNull
    @Schema(description = "등록일시", required = true)
    var createdDate: ZonedDateTime? = ZonedDateTime.now(),

    /**
     * 수정자ID
     */
    @get: NotNull
    @get: Size(max = 100)
    @Schema(description = "수정자ID", required = true)
    var lastModifiedBy: String? = "",

    /**
     * 수정일시
     */
    @get: NotNull
    @Schema(description = "수정일시", required = true)
    var lastModifiedDate: ZonedDateTime? = ZonedDateTime.now(),
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdCommonGroupCodeDTO) return false
        val stdCommonGroupCodeDTO = other
        if (this.id == null) {
            return false
        }
        return Objects.equals(this.id, stdCommonGroupCodeDTO.id)
    }

    override fun hashCode() = Objects.hash(this.id)
}
