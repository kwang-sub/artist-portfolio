package com.artist.server.web.rest.std

import com.artist.server.service.std.AdminPasswordService
import com.artist.server.service.std.dto.AdminPasswordReqDTO
import com.artist.server.service.std.dto.AdminResDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class AdminPasswordResource(
    private val adminPasswordService: AdminPasswordService,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PutMapping("/std-admin-passwords/{adminId}/reset")
    fun reset(
        @PathVariable
        adminId: Long,
        @Valid
        @RequestBody
        adminPasswordReqDTO: AdminPasswordReqDTO
    ): ResponseEntity<AdminResDTO> {
        log.debug("REST request to save StdAdminPassword : $adminPasswordReqDTO")
        val result = adminPasswordService.reset(adminPasswordReqDTO.apply { this.adminId = adminId })
        return ResponseEntity.ok(result)
    }
}
