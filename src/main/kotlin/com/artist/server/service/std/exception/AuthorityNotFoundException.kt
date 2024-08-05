package com.artist.server.service.std.exception

import com.artist.server.constant.StdConstants

class AuthorityNotFoundException : RuntimeException(StdConstants.MSG_AUTHORITY_NOT_FOUND) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
