package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdCommonCode
import com.artist.server.domain.core.StdCommonGroupCode
import com.artist.server.service.core.dto.StdCommonCodeDTO
import com.artist.server.service.core.dto.StdCommonGroupCodeDTO
import org.mapstruct.*

/**
 * Mapper for the entity [StdCommonCode] and its DTO [StdCommonCodeDTO].
 */
@Mapper(componentModel = "spring")
interface StdCommonCodeMapper :
    EntityMapper<StdCommonCodeDTO, StdCommonCode> {

    @Mappings(
        Mapping(target = "commonGroupCode", source = "commonGroupCode", qualifiedByName = ["stdCommonGroupCodeId"])
    )
    override fun toDto(s: StdCommonCode): StdCommonCodeDTO

    @Named("stdCommonGroupCodeId")
    @BeanMapping(ignoreByDefault = true)

    @Mappings(
        Mapping(target = "id", source = "id")
    )
    fun toDtoStdCommonGroupCodeId(stdCommonGroupCode: StdCommonGroupCode): StdCommonGroupCodeDTO
}
