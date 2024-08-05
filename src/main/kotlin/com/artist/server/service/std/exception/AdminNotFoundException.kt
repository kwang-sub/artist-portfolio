package com.artist.server.service.std.exception

import com.artist.server.constant.StdConstants

class AdminNotFoundException : RuntimeException(StdConstants.MSG_ADMIN_NOT_FOUND) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
