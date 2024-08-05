package com.artist.server.factory

import com.artist.server.repository.core.StdMessageRepository
import com.artist.server.service.core.dto.StdMessageDTO
import com.artist.server.service.core.mapper.StdMessageMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

class MessageCode {
    class Std

    class Suv

    class Hop

    class Usr
}

@Component
class MessageFactory(
    val messageRepository: StdMessageRepository,
    var messageMapper: StdMessageMapper,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun getMessage(messageCode: String): StdMessageDTO {
        log.info("====================== EXCEPTION to $messageCode ==================================")
        val stdMessage =
            messageRepository.findTop1ByMessageCodeAndIsActivatedTrueAndIsDeletedFalse(messageCode)
        return if (stdMessage.isPresent) messageMapper.toDto(stdMessage.get())
        else StdMessageDTO(messageCode = "MSG404", messageContent = "공통메시지를 찾을 수 없습니다.")
    }
}
