package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdAdmin
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.AdminSaveReqDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAdmin] and its DTO [AdminSaveReqDTO].
 */
@Mapper(componentModel = "spring")
interface AdminReqMapper : EntityMapper<AdminSaveReqDTO, StdAdmin>
