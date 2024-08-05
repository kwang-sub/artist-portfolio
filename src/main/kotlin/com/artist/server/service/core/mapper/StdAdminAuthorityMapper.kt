package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdAdminAuthority
import com.artist.server.domain.core.StdAuthority
import com.artist.server.service.core.dto.StdAdminAuthorityDTO
import com.artist.server.service.core.dto.StdAuthorityDTO
import org.mapstruct.*

/**
 * Mapper for the entity [StdAdminAuthority] and its DTO [StdAdminAuthorityDTO].
 */
@Mapper(componentModel = "spring")
interface StdAdminAuthorityMapper :
    EntityMapper<StdAdminAuthorityDTO, StdAdminAuthority> {

    @Mappings(
        Mapping(target = "authorityCode", source = "authorityCode", qualifiedByName = ["stdAuthorityId"])
    )
    override fun toDto(s: StdAdminAuthority): StdAdminAuthorityDTO

    @Named("stdAuthorityId")
    @BeanMapping(ignoreByDefault = true)

    @Mappings(
        Mapping(target = "id", source = "id")
    )
    fun toDtoStdAuthorityId(stdAuthority: StdAuthority): StdAuthorityDTO
}
