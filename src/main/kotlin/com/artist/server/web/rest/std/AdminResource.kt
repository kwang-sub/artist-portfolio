package com.artist.server.web.rest.std

import com.artist.server.domain.core.StdAuthority
import com.artist.server.service.std.AdminQueryService
import com.artist.server.service.std.AdminService
import com.artist.server.service.std.criteria.AdminCriteria
import com.artist.server.service.std.dto.AdminResDTO
import com.artist.server.service.std.dto.AdminSaveReqDTO
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import tech.jhipster.web.util.PaginationUtil
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class AdminResource(
    private val adminQueryService: AdminQueryService,
    private val adminService: AdminService,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/std-admins")
    fun findList(
        criteria: AdminCriteria,
        @org.springdoc.api.annotations.ParameterObject
        pageable: Pageable,
    ): ResponseEntity<Page<AdminResDTO>> {
        log.debug("REST request to get getAllStdAdminList by criteria: $criteria")
        val page = adminQueryService.findByCriteria(criteria, pageable, arrayListOf(StdAuthority.CODE_AUTHORITY_ADMIN))
        val headers =
            PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page)
        return ResponseEntity
            .ok()
            .headers(headers)
            .body(page)
    }

    @GetMapping("/std-admins/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<AdminResDTO> {
        log.debug("REST request to get StdAdmin : $id")
        val result = adminService.findOne(id)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/std-admins")
    fun insert(@RequestBody @Valid adminSaveReqDTO: AdminSaveReqDTO): ResponseEntity<AdminResDTO> {
        log.debug("REST request to inser StdAdmin for admin : $adminSaveReqDTO")
        val result = adminService.save(adminSaveReqDTO)
        return ResponseEntity.ok(result)
    }

    @PutMapping("/std-admins/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody adminSaveReqDTO: AdminSaveReqDTO,
    ): ResponseEntity<AdminResDTO> {
        log.debug("REST request to update StdAdmin for admin : $adminSaveReqDTO")
        val result = adminService.update(adminSaveReqDTO.apply { this.id = id })
        return ResponseEntity.ok(result)
    }

    @DeleteMapping("/std-admins/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Long> {
        log.debug("REST request to delete StdAdmin : $id")
        adminService.delete(id)
        return ResponseEntity.ok(id)
    }
}
