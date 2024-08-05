package com.artist.server.service.core.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.StdMessage] entity.
 */
@Schema(description = "공통메시지")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdMessageDTO(

    var id: Long? = null,

    /**
     * 메시지유형코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Schema(description = "메시지유형코드", required = true)
    var messageTypeCode: String? = null,

    /**
     * 메시지코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Schema(description = "메시지코드", required = true)
    var messageCode: String? = null,

    /**
     * 메시지내용
     */
    @get: NotNull
    @get: Size(max = 1000)
    @Schema(description = "메시지내용", required = true)
    var messageContent: String? = null,

    /**
     * 정렬순서
     */
    @get: NotNull
    @Schema(description = "정렬순서", required = true)
    var sortOrder: Int? = null,

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
        if (other !is StdMessageDTO) return false
        val stdMessageDTO = other
        if (this.id == null) {
            return false
        }
        return Objects.equals(this.id, stdMessageDTO.id)
    }

    override fun hashCode() = Objects.hash(this.id)
}
