package com.artist.server.service.std.exception

import com.artist.server.constant.StdConstants

class InvalidResetPasswordException : RuntimeException(StdConstants.MSG_NOT_EQUALS_RESET_PASSWORD) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
