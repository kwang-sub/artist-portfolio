package com.artist.server.service.std.dto

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

data class AdminPasswordResDTO(

    /**
     * 변경된 유저 ID
     */
    @get: NotNull
    @param: NotNull
    @Schema(description = "변경된 유저 ID", required = true)
    var adminId: Long,

)
