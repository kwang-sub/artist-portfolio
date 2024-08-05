package com.artist.server.service.core.mapper

import com.artist.server.domain.core.StdMessage
import com.artist.server.service.core.dto.StdMessageDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdMessage] and its DTO [StdMessageDTO].
 */
@Mapper(componentModel = "spring")
interface StdMessageMapper :
    EntityMapper<StdMessageDTO, StdMessage>
