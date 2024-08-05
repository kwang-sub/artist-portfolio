package com.artist.server.service.std.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * A DTO for the [com.artist.server.domain.core.StdAdmin] entity.
 */
@Schema(description = "어드민계정")
@SuppressWarnings("common-java:DuplicatedBlocks")
data class ServiceAdminResDTO(

    var id: Long? = null,

    /**
     * 사용자명
     */
    @get: NotNull
    @get: Size(max = 50)
    @field: NotNull
    @Schema(description = "사용자명", required = true)
    var adminUserName: String? = null,

    /**
     * 어드민서명이미지
     */
    @Schema(description = "서명이미지")
    @JsonIgnoreProperties(
        value = [
            "contentsCreateDate",
            "isDeleted",
            "createdBy",
            "createdDate",
            "lastModifiedBy",
            "lastModifiedDate",
        ],
        allowSetters = true
    )
    var adminSignImage: ContentsResDTO? = null,

) : Serializable
