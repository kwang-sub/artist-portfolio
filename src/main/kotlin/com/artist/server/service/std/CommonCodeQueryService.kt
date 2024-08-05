package com.artist.server.service.std

import com.artist.server.domain.core.StdCommonCode
import com.artist.server.domain.core.StdCommonCode_
import com.artist.server.domain.core.StdCommonGroupCode_
import com.artist.server.repository.std.CommonCodeRepository
import com.artist.server.service.core.criteria.StdCommonCodeCriteria
import com.artist.server.service.core.dto.StdCommonCodeDTO
import com.artist.server.service.std.criteria.CommonCodeCriteria
import com.artist.server.service.std.dto.CommonCodeResDTO
import com.artist.server.service.std.mapper.CommonCodeResMapper
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.jhipster.service.QueryService
import tech.jhipster.service.filter.BooleanFilter
import javax.persistence.criteria.JoinType

/**
 * Service for executing complex queries for [StdCommonCode] entities in the database.
 * The main input is a [StdCommonCodeCriteria] which gets converted to [Specification],
 * in a way that all the filters must apply.
 * It returns a [MutableList] of [StdCommonCodeDTO] or a [Page] of [StdCommonCodeDTO] which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
class CommonCodeQueryService(
    private val commonCodeRepository: CommonCodeRepository,
    private val commonCodeResMapper: CommonCodeResMapper,
) : QueryService<StdCommonCode>() {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Return a [MutableList] of [StdCommonCodeDTO] which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    fun findByCriteria(criteria: CommonCodeCriteria?): MutableList<CommonCodeResDTO> {
        log.debug("find by criteria : $criteria")
        val specification = createSpecification(criteria)
        return commonCodeResMapper.toDto(commonCodeRepository.findAll(specification))
    }

    /**
     * Return a [Page] of [StdCommonCodeDTO] which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    fun findByCriteria(
        criteria: CommonCodeCriteria?,
        page: Pageable
    ): Page<CommonCodeResDTO> {
        log.debug("find by criteria : $criteria, page: $page")
        val specification = createSpecification(criteria)
        return commonCodeRepository
            .findAll(specification, page)
            .map(commonCodeResMapper::toDto)
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    fun countByCriteria(criteria: CommonCodeCriteria?): Long {
        log.debug("count by criteria : $criteria")
        val specification = createSpecification(criteria)
        return commonCodeRepository.count(specification)
    }

    /**
     * Function to convert [StdCommonCodeCriteria] to a [Specification].
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching [Specification] of the entity.
     */
    protected fun createSpecification(criteria: CommonCodeCriteria?): Specification<StdCommonCode?> {
        var specification: Specification<StdCommonCode?> = Specification
            .where<StdCommonCode?>(null)
            .and(
                buildSpecification(
                    BooleanFilter().apply {
                        equals = false
                    },
                    StdCommonCode_.isDeleted
                )
            )

        criteria?.run {
            specification = distinct?.let { specification.and(distinct(it)) } ?: specification

            specification = commonGroupCode?.let {

                specification.and(
                    buildSpecification(it) { commonCode ->
                        commonCode
                            .join(StdCommonCode_.commonGroupCode, JoinType.LEFT)
                            .get(StdCommonGroupCode_.commonGroupCode)
                    }
                )
            } ?: specification

            specification = commonGroupCodeName?.let {

                specification.and(
                    buildSpecification(it) { commonCode ->
                        commonCode
                            .join(StdCommonCode_.commonGroupCode, JoinType.LEFT)
                            .get(StdCommonGroupCode_.commonGroupCodeName)
                    }
                )
            } ?: specification

            specification = commonCode?.let {
                specification.and(
                    buildStringSpecification(it, StdCommonCode_.commonCode)
                )
            } ?: specification

            specification = commonCodeName?.let {
                specification.and(
                    buildStringSpecification(it, StdCommonCode_.commonCodeName)
                )
            } ?: specification

            specification = commonCodeDesc?.let {
                specification.and(
                    buildStringSpecification(it, StdCommonCode_.commonCodeDesc)
                )
            } ?: specification

            specification = sortNum?.let {
                specification.and(
                    buildRangeSpecification(it, StdCommonCode_.sortNum)
                )
            } ?: specification

            specification = isActivated?.let {
                specification.and(
                    buildSpecification(it, StdCommonCode_.isActivated)
                )
            } ?: specification

            specification = isDeleted?.let {
                specification.and(
                    buildSpecification(it, StdCommonCode_.isDeleted)
                )
            } ?: specification

            specification = createdBy?.let { specification.and(buildStringSpecification(it, StdCommonCode_.createdBy)) }
                ?: specification

            specification =
                createdDate?.let { specification.and(buildRangeSpecification(it, StdCommonCode_.createdDate)) }
                    ?: specification

            specification = lastModifiedBy?.let {
                specification.and(
                    buildStringSpecification(it, StdCommonCode_.lastModifiedBy)
                )
            } ?: specification

            specification = lastModifiedDate?.let {
                specification.and(
                    buildRangeSpecification(it, StdCommonCode_.lastModifiedDate)
                )
            } ?: specification
        }

        return specification
    }
}
