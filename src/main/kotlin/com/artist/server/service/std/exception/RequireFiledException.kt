package com.artist.server.service.std.exception

import com.artist.server.constant.StdConstants

class RequireFiledException(filedName: String) :
    RuntimeException(String.format(StdConstants.MSG_REQUIRE_FILED, filedName)) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
