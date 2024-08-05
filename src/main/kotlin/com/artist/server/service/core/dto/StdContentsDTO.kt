package com.artist.server.service.core.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.*
import javax.validation.constraints.*

/**
 * A DTO for the [com.artist.server.domain.StdContents] entity.
 */
@Schema(description = "컨텐츠")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdContentsDTO(

    var id: Long? = null,

    /**
     * 컨텐츠생성일시
     */
    @get: NotNull
    @Schema(description = "컨텐츠생성일시", required = true)
    var contentsCreateDate: ZonedDateTime? = null,

    /**
     * 컨텐츠명
     */
    @get: NotNull
    @get: Size(max = 50)
    @Schema(description = "컨텐츠명", required = true)
    var contentsName: String? = null,

    /**
     * 컨텐츠원본명
     */
    @get: NotNull
    @get: Size(max = 100)
    @Schema(description = "컨텐츠원본명", required = true)
    var contentsOgName: String? = null,

    /**
     * 컨텐츠경로
     */
    @get: NotNull
    @get: Size(max = 100)
    @Schema(description = "컨텐츠경로", required = true)
    var contentsPath: String? = null,

    /**
     * 컨텐츠사이즈
     */
    @get: NotNull
    @Schema(description = "컨텐츠사이즈", required = true)
    var contentsSize: Int? = null,

    /**
     * 컨텐츠유형
     */
    @get: NotNull
    @get: Size(max = 25)
    @Schema(description = "컨텐츠유형", required = true)
    var contentsType: String? = null,

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
        if (other !is StdContentsDTO) return false
        val stdContentsDTO = other
        if (this.id == null) {
            return false
        }
        return Objects.equals(this.id, stdContentsDTO.id)
    }

    override fun hashCode() = Objects.hash(this.id)
}
