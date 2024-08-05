package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdCommonGroupCode
import com.artist.server.service.core.dto.StdCommonGroupCodeDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdCommonGroupCode] and its DTO [StdCommonGroupCodeDTO].
 */
@Mapper(componentModel = "spring")
interface StdCommonGroupCodeMapper :
    EntityMapper<StdCommonGroupCodeDTO, StdCommonGroupCode>
