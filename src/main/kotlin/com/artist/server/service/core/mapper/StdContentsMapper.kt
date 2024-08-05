package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdContents
import com.artist.server.service.core.dto.StdContentsDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdContents] and its DTO [StdContentsDTO].
 */
@Mapper(componentModel = "spring")
interface StdContentsMapper :
    EntityMapper<StdContentsDTO, StdContents>
