package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdAdmin
import com.artist.server.service.core.dto.StdAdminDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAdmin] and its DTO [StdAdminDTO].
 */
@Mapper(componentModel = "spring")
interface StdAdminMapper : EntityMapper<StdAdminDTO, StdAdmin>
