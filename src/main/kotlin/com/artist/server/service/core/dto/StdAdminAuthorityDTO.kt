package com.artist.server.service.core.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * A DTO for the [com.artist.server.domain.core.StdAdminAuthority] entity.
 */
@Schema(description = "어드민권한관계")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdminAuthorityDTO(

    var id: Long? = null,

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

    @Schema(description = "어드민")
    var admin: StdAdminDTO? = null,

    @Schema(description = "권한")
    var authorityCode: StdAuthorityDTO? = null,
) : Serializable
