package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdAdminPassword
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.AdminPasswordReqDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAdminPassword] and its DTO [AdminPasswordReqDTO].
 */
@Mapper(componentModel = "spring")
interface AdminPasswordReqMapper : EntityMapper<AdminPasswordReqDTO, StdAdminPassword>
