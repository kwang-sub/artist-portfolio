package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdAdmin
import com.artist.server.domain.core.StdCommonGroupCode
import com.artist.server.service.core.dto.StdAdminDTO
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.CommonGroupCodeResDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdAdmin] and its DTO [StdAdminDTO].
 */
@Mapper(componentModel = "spring")
interface CommonGroupCodeResMapper : EntityMapper<CommonGroupCodeResDTO, StdCommonGroupCode>
