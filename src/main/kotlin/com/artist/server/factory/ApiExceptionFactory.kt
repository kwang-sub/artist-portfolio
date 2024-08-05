package com.artist.server.factory

import com.artist.server.service.std.exception.errors.BadRequestApiException
import org.springframework.stereotype.Component

class ErrorCode {
    class Std {
        companion object {
            /** 권한을 찾을 수 없습니다. */
            const val AUTHORITY_NOT_FOUND = "ST01001"
            /** 허용되지 않은 권한입니다 */
            const val AUTHORITY_BAD_PERMISSION = "ST01002"
            /** 사용자를 찾을 수 없습니다 */
            const val ADMIN_NOT_FOUND = "ST02001"
            /** 중복된 ID 가 있습니다 */
            const val ADMIN_ID_IS_DUPLICATED = "ST02002"
            /** 비밀번호가 일치하지 않습니다 */
            const val ADMIN_PASSWORD_IS_NOT_EQUALS = "ST03001"
            /** 공통 그룹코드를 찾을 수 없습니다. */
            const val COMMON_GROUP_CODE_NOT_FOUND = "ST05001"
            /** 권한에 해당하는 메뉴를 찾을 수 없습니다. */
            const val MENU_NOT_FOUND = "ST07001"
            /** 사업자번호가 없습니다. */
            const val NOT_FOUND_BUSINESS_REQ_NUMBER = "ST08002"
            /** 파일 업로드에 실패했습니다. */
            const val CONTENT_UPLOAD_FAILED = "ST09001"
            /** 파일 저장 경로를 가져오는데 실패했습니다. */
            const val BAD_CONTENT_PATH = "ST09091"
            /** 파일을 찾을 수 없습니다. */
            const val NOT_FOUND_FILE = "ST09092"
            /** 파일변환에 실패했습니다 */
            const val FAILED_TO_FILE_TO_BYTE_ARRAY = "ST09093"
        }
    }
}

@Component
class ApiExceptionFactory(
    private val stdMessageFactory: MessageFactory
) {

    fun badRequest(errorCode: String) = stdMessageFactory
        .getMessage(errorCode)
        .let {
            BadRequestApiException(
                errorKey = it.messageCode ?: "MSG404",
                message = it.messageContent ?: "공통메시지를 찾을 수 없습니다.",
            )
        }
}
