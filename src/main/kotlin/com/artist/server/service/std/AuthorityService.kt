package com.artist.server.service.std

import com.artist.server.domain.core.StdAuthority
import com.artist.server.repository.std.AuthorityRepository
import com.artist.server.service.core.dto.StdAuthorityDTO
import com.artist.server.service.core.mapper.StdAuthorityMapper
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * Service Implementation for managing [StdAuthority].
 */
@Service
@Transactional
class AuthorityService(
    private val authorityRepository: AuthorityRepository,
    private val stdAuthorityMapper: StdAuthorityMapper,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    /**
     * Save a stdAuthority.
     *
     * @param stdAuthorityDTO the entity to save.
     * @return the persisted entity.
     */
    fun save(stdAuthorityDTO: StdAuthorityDTO): StdAuthorityDTO {
        log.debug("Request to save StdAuthority : $stdAuthorityDTO")
        var stdAuthority = stdAuthorityMapper.toEntity(stdAuthorityDTO)
        stdAuthority = authorityRepository.save(stdAuthority)
        return stdAuthorityMapper.toDto(stdAuthority)
    }

    /**
     * Update a stdAuthority.
     *
     * @param stdAuthorityDTO the entity to save.
     * @return the persisted entity.
     */
    fun update(stdAuthorityDTO: StdAuthorityDTO): StdAuthorityDTO {
        log.debug("Request to update StdAuthority : {}", stdAuthorityDTO)
        var stdAuthority = stdAuthorityMapper.toEntity(stdAuthorityDTO)
        stdAuthority = authorityRepository.save(stdAuthority)
        return stdAuthorityMapper.toDto(stdAuthority)
    }

    /**
     * Partially updates a stdAuthority.
     *
     * @param stdAuthorityDTO the entity to update partially.
     * @return the persisted entity.
     */
    fun partialUpdate(stdAuthorityDTO: StdAuthorityDTO): Optional<StdAuthorityDTO> {
        log.debug("Request to partially update StdAuthority : {}", stdAuthorityDTO)

        return authorityRepository
            .findById(stdAuthorityDTO.id)
            .map {
                stdAuthorityMapper.partialUpdate(it, stdAuthorityDTO)
                it
            }
            .map { authorityRepository.save(it) }
            .map { stdAuthorityMapper.toDto(it) }
    }

    /**
     * Get all the stdAuthorities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<StdAuthorityDTO> {
        log.debug("Request to get all StdAuthorities")
        return authorityRepository
            .findAll(pageable)
            .map(stdAuthorityMapper::toDto)
    }

    /**
     * Get one stdAuthority by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    fun findOne(id: Long): Optional<StdAuthorityDTO> {
        log.debug("Request to get StdAuthority : $id")
        return authorityRepository
            .findById(id)
            .map(stdAuthorityMapper::toDto)
    }

    /**
     * Delete the stdAuthority by id.
     *
     * @param id the id of the entity.
     */
    fun delete(id: Long) {
        log.debug("Request to delete StdAuthority : $id")

        authorityRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun findOneByCode(code: String): Optional<StdAuthorityDTO> {
        log.debug("Request to get StdAuthority : $code")
        return authorityRepository
            .findByAuthorityCodeAndIsDeletedIsFalse(code)
            .map(stdAuthorityMapper::toDto)
    }
}
