package com.artist.server.service.std.mapper

import com.artist.server.domain.core.StdContents
import com.artist.server.service.core.mapper.EntityMapper
import com.artist.server.service.std.dto.ContentsResDTO
import org.mapstruct.Mapper

/**
 * Mapper for the entity [StdContents] and its DTO [ContentsResDTO].
 */
@Mapper(componentModel = "spring")
interface ContentsResMapper : EntityMapper<ContentsResDTO, StdContents>
