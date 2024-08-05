package com.artist.server.service.std.exception

import com.artist.server.constant.StdConstants

class DuplicateLoginIdException : RuntimeException(StdConstants.MSG_DUPLICATE_LOGIN_ID) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
