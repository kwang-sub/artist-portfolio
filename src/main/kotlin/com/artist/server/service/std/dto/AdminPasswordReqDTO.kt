package com.artist.server.service.std.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AdminPasswordReqDTO(

    /**
     * 변경될 유저 ID
     */
    @get: NotNull
    @param: NotNull
    @Schema(description = "변경될 유저 ID", required = true)
    var adminId: Long,

    /**
     * 이전 비밀번호
     */
    @get: NotNull
    @get: Size(max = 255)
    @param: NotNull
    @Schema(description = "이전 비밀번호", required = true)
    var beforeAdminPassword: String,

    /**
     * 변경 비밀번호
     */
    @get: NotNull
    @get: Size(max = 255)
    @param: NotNull
    @Schema(description = "이전 비밀번호", required = true)
    var afterAdminPassword: String,

    /**
     * 변경 비밀번호 확인
     */
    @get: NotNull
    @get: Size(max = 255)
    @param: NotNull
    @Schema(description = "변경 비밀번호", required = true)
    var afterAdminPasswordCheck: String,
)
