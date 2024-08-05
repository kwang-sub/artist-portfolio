package com.artist.server.service.std

import com.artist.server.domain.core.*
import com.artist.server.repository.core.StdAdminRepository
import com.artist.server.service.core.criteria.StdAdminCriteria
import com.artist.server.service.core.dto.StdAdminDTO
import com.artist.server.service.std.criteria.AdminCriteria
import com.artist.server.service.std.dto.AdminResDTO
import com.artist.server.service.std.mapper.AdminResMapper
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.jhipster.service.QueryService
import tech.jhipster.service.filter.BooleanFilter
import tech.jhipster.service.filter.Filter
import tech.jhipster.service.filter.StringFilter
import javax.persistence.criteria.JoinType

/**
 * Service for executing complex queries for [StdAdmin] entities in the database.
 * The main input is a [StdAdminCriteria] which gets converted to [Specification],
 * in a way that all the filters must apply.
 * It returns a [MutableList] of [StdAdminDTO] or a [Page] of [StdAdminDTO] which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
class AdminQueryService(
    private val stdAdminRepository: StdAdminRepository,
    private val adminResMapper: AdminResMapper,
) : QueryService<StdAdmin>() {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Return a [MutableList] of [StdAdminDTO] which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    fun findByCriteria(criteria: AdminCriteria?): MutableList<AdminResDTO> {
        log.debug("find by criteria : $criteria")
        val specification = createSpecification(criteria)
        return adminResMapper.toDto(stdAdminRepository.findAll(specification))
    }

    /**
     * Return a [Page] of [StdAdminDTO] which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    fun findByCriteria(
        criteria: AdminCriteria?,
        page: Pageable,
        authorityList: List<String>? = null
    ): Page<AdminResDTO> {
        log.debug("find by criteria : $criteria, page: $page")
        val specification = createSpecification(criteria, authorityList)
        return stdAdminRepository
            .findAll(specification, page)
            .map(adminResMapper::toDto)
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    fun countByCriteria(criteria: AdminCriteria?): Long {
        log.debug("count by criteria : $criteria")
        val specification = createSpecification(criteria)
        return stdAdminRepository.count(specification)
    }

    /**
     * Function to convert [StdAdminCriteria] to a [Specification].
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching [Specification] of the entity.
     */
    protected fun createSpecification(
        criteria: AdminCriteria?,
        authorityList: List<String>? = null
    ): Specification<StdAdmin?> {
        var specification: Specification<StdAdmin?> = Specification
            .where<StdAdmin?>(null)
            .and(
                buildSpecification(
                    BooleanFilter().apply {
                        equals = false
                    },
                    StdAdmin_.isDeleted
                )
            )

        criteria?.run {
            specification = distinct?.let { specification.and(distinct(it)) } ?: specification

            specification = authorityList?.let {
                specification.and(
                    buildSpecification(
                        StringFilter().apply {
                            `in` = it
                        }
                    ) { admin ->
                        admin
                            .join(StdAdmin_.stdAuthorities, JoinType.LEFT)
                            .get(StdAuthority_.authorityCode)
                    }
                )
            } ?: specification

            specification = authorityId?.let {
                specification.and(
                    buildSpecification(it as Filter<Long>) { admin ->
                        admin
                            .join(StdAdmin_.stdAuthorities, JoinType.LEFT)
                            .get(StdAuthority_.id)
                    }
                )
            } ?: specification

            specification =
                adminLoginId?.let { specification.and(buildStringSpecification(it, StdAdmin_.adminLoginId)) }
                    ?: specification
            specification =
                adminUserName?.let { specification.and(buildStringSpecification(it, StdAdmin_.adminUserName)) }
                    ?: specification
            specification =
                adminPhoneNum?.let { specification.and(buildStringSpecification(it, StdAdmin_.adminPhoneNum)) }
                    ?: specification
            specification = adminEmail?.let { specification.and(buildStringSpecification(it, StdAdmin_.adminEmail)) }
                ?: specification
            specification =
                isActivated?.let { specification.and(buildSpecification(it, StdAdmin_.isActivated)) } ?: specification
            specification =
                createdBy?.let { specification.and(buildStringSpecification(it, StdAdmin_.createdBy)) } ?: specification
            specification = createdDate?.let { specification.and(buildRangeSpecification(it, StdAdmin_.createdDate)) }
                ?: specification
            specification =
                lastModifiedBy?.let { specification.and(buildStringSpecification(it, StdAdmin_.lastModifiedBy)) }
                    ?: specification
            specification =
                lastModifiedDate?.let { specification.and(buildRangeSpecification(it, StdAdmin_.lastModifiedDate)) }
                    ?: specification
        }

        return specification
    }
}
