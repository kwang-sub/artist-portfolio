package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdCommonCode
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.CommonCodeReqDTO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

/**
 * Mapper for the entity [StdCommonCode] and its DTO [CommonCodeReqDTO].
 */
@Mapper(componentModel = "spring")
interface CommonCodeReqMapper : EntityMapper<CommonCodeReqDTO, StdCommonCode> {
    @Mappings(
        Mapping(target = "commonGroupCode", source = "commonGroupCode")
    )
    override fun toDto(entity: StdCommonCode): CommonCodeReqDTO
}
