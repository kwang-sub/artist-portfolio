package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdCommonGroupCode
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.CommonGroupCodeReqDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdCommonGroupCode] and its DTO [CommonGroupCodeReqDTO].
 */
@Mapper(componentModel = "spring")
interface CommonGroupCodeReqMapper : EntityMapper<CommonGroupCodeReqDTO, StdCommonGroupCode>
