package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdCommonCode
import com.artist.server.domain.core.StdCommonGroupCode
import com.artist.server.service.core.dto.StdCommonCodeDTO
import com.artist.server.service.core.dto.StdCommonGroupCodeDTO
import com.artist.server.service.core.mapper.EntityMapper
import org.mapstruct.*

/**
 * Mapper for the entity [StdCommonGroupCode] and its DTO [StdCommonGroupCodeDTO].
 */
@Mapper(componentModel = "spring")
interface CommonGroupCodeMapper : EntityMapper<StdCommonCodeDTO, StdCommonCode> {

    @Mappings(
        Mapping(target = "commonGroupCode", source = "commonGroupCode", qualifiedByName = ["stdCommonGroupCodeId"])
    )
    override fun toDto(entity: StdCommonCode): StdCommonCodeDTO

    @Named("stdCommonGroupCodeId")
    @BeanMapping(ignoreByDefault = true)

    @Mappings(
        Mapping(target = "id", source = "id")
    )
    fun toDtoStdCommonGroupCodeId(stdCommonGroupCode: StdCommonGroupCode): StdCommonGroupCodeDTO
}
