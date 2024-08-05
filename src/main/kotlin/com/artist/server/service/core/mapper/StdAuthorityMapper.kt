package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdAuthority
import com.artist.server.service.core.dto.StdAuthorityDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAuthority] and its DTO [StdAuthorityDTO].
 */
@Mapper(componentModel = "spring")
interface StdAuthorityMapper : EntityMapper<StdAuthorityDTO, StdAuthority>
