package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdCommonCode
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.CommonCodeResDTO
import org.mapstruct.*

/**
 * Mapper for the entity [StdCommonCode] and its DTO [CommonCodeResDTO].
 */
@Mapper(componentModel = "spring")
interface CommonCodeResMapper : EntityMapper<CommonCodeResDTO, StdCommonCode> {

    @Mappings(
        Mapping(target = "groupCode", source = "commonGroupCode.commonGroupCode")
    )
    override fun toDto(entity: StdCommonCode): CommonCodeResDTO
}
