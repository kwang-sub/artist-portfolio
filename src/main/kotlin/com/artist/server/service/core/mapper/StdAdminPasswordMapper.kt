package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdAdmin
import com.artist.server.domain.core.StdAdminPassword
import com.artist.server.service.core.dto.StdAdminDTO
import com.artist.server.service.core.dto.StdAdminPasswordDTO
import org.mapstruct.*

/**
 * Mapper for the entity [StdAdminPassword] and its DTO [StdAdminPasswordDTO].
 */
@Mapper(componentModel = "spring")
interface StdAdminPasswordMapper :
    EntityMapper<StdAdminPasswordDTO, StdAdminPassword> {

    @Mappings(
        Mapping(target = "admin", source = "admin", qualifiedByName = ["stdAdminId"])
    )
    override fun toDto(s: StdAdminPassword): StdAdminPasswordDTO

    @Named("stdAdminId")
    @BeanMapping(ignoreByDefault = true)

    @Mappings(
        Mapping(target = "id", source = "id")
    )
    fun toDtoStdAdminId(stdAdmin: StdAdmin): StdAdminDTO
}
