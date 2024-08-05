package com.artist.server.service.std.dto

import com.artist.server.constant.StdConstants
import com.artist.server.web.rest.std.validator.DescriptionValidWord
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AdminSaveReqDTO(
    var id: Long? = null,

    /**
     * 어드민로그인아이디
     */
    @get: NotNull
    @get: Size(max = 100)
    @param: NotNull
    @Schema(description = "로그인아이디", required = true)
    var adminLoginId: String,

    /**
     * 어드민비밀번호
     */
    @get: Size(max = 255)
    @Schema(description = "비밀번호")
    var adminPassword: String?,

    /**
     * 활성화여부
     */
    @get: NotNull
    @param: NotNull
    @Schema(description = "활성화여부", required = true)
    val isActivated: Boolean = true,

    /**
     * 어드민명
     */
    @get: NotNull
    @get: Size(max = 50)
    @param: NotNull
    @DescriptionValidWord(
        message = StdConstants.MSG_ADMIN_NAME_INVALID, invalidWord = ["바보", "메롱"]
    )
    @Schema(description = "이름", required = true)
    val adminUserName: String,

    /**
     * 어드민연락처
     */
    @get: NotNull
    @get: Size(max = 30)
    @param: NotNull
    @Schema(description = "연락처", required = true)
    val adminPhoneNum: String,

    /**
     * 어드민이메일
     */
    @get: NotNull
    @get: Size(max = 100)
    @param: NotNull
    @Schema(description = "이메일", required = true)
    val adminEmail: String,

)
