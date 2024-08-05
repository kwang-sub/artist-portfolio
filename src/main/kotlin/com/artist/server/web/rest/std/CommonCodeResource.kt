package com.artist.server.web.rest.std

import com.artist.server.service.std.CommonCodeQueryService
import com.artist.server.service.std.criteria.CommonCodeCriteria
import com.artist.server.service.std.dto.CommonCodeResDTO
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CommonCodeResource(
    private val commonCodeQueryService: CommonCodeQueryService,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/std-common-codes")
    fun getAllStdCommonCodeList(
        criteria: CommonCodeCriteria,
        pageable: Pageable,
    ): ResponseEntity<Page<CommonCodeResDTO>> {
        log.debug("REST request to get StdAdmins by criteria: $criteria")
        val result = commonCodeQueryService.findByCriteria(criteria, pageable)
        return ResponseEntity.ok(result)
    }
}
