package com.artist.server.service.std.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * A DTO for the [com.artist.server.domain.core.StdAdmin] entity.
 */
@Schema(description = "어드민계정")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class AdminAuthorityResDTO(

    var id: Long? = null,

    /**
     * 사용자로그인아이디
     */
    @get: NotNull
    @get: Size(max = 100)
    @field: NotNull
    @Schema(description = "사용자로그인아이디", required = true)
    var adminLoginId: String? = null,

    /**
     * 사용자명
     */
    @get: NotNull
    @get: Size(max = 50)
    @field: NotNull
    @Schema(description = "사용자명", required = true)
    var adminUserName: String? = null,

    /**
     * 사용자연락처
     */
    @get: NotNull
    @get: Size(max = 30)
    @field: NotNull
    @Schema(description = "사용자연락처", required = true)
    var adminPhoneNum: String? = null,

    /**
     * 사용자이메일
     */
    @get: NotNull
    @get: Size(max = 100)
    @field: NotNull
    @Schema(description = "사용자이메일", required = true)
    var adminEmail: String? = null,

    /**
     * 활성화여부
     */
    @get: NotNull
    @field: NotNull
    @Schema(description = "활성화여부", required = true)
    var isActivated: Boolean? = true,

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
    var lastModifiedDate: ZonedDateTime? = ZonedDateTime.now()
) : Serializable
