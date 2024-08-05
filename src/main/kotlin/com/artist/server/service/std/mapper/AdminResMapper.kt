package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdAdmin
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.AdminResDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAdmin] and its DTO [AdminResDTO].
 */
@Mapper(componentModel = "spring")
interface AdminResMapper : EntityMapper<AdminResDTO, StdAdmin>
