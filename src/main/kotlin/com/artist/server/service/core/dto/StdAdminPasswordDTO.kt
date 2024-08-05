package com.artist.server.service.core.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.StdAdminPassword] entity.
 */
@Schema(description = "어드민계정비밀번호변경이력")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdminPasswordDTO(

    var id: Long? = null,

    /**
     * 이전비밀번호
     */
    @get: NotNull
    @get: Size(max = 255)
    @Schema(description = "이전비밀번호", required = true)
    var beforePassword: String? = null,

    /**
     * 변경비밀번호
     */
    @get: NotNull
    @get: Size(max = 255)
    @Schema(description = "변경비밀번호", required = true)
    var afterPassword: String? = null,

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

    var admin: StdAdminDTO? = null,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdAdminPasswordDTO) return false
        val stdAdminPasswordDTO = other
        if (this.id == null) {
            return false
        }
        return Objects.equals(this.id, stdAdminPasswordDTO.id)
    }

    override fun hashCode() = Objects.hash(this.id)
}
