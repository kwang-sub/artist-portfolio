package com.artist.server.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class SeedUtils {

    @Value("\${seed-key.key}")
    private val seedKey: String? = null

    @Value("\${seed-key.bszIV}")
    private val bszivKey: String? = null

    /**
     * 암호화
     * 문자열 Kisa Seed로 암호화 후 학사코드 변환 리턴
     * @param str 암호화 문자열
     */
    fun encode(str: String): String {
        if (isEncrypted(str)) {
            return str
        }

        val key = seedKey!!.toByteArray()
        val bszIV = bszivKey!!.toByteArray()
        val strBytes = str.toByteArray()
        val encrypted = KisaSeedCbc.SEED_CBC_Encrypt(key, bszIV, strBytes, 0, strBytes.size)

        return byteArrayToHexString(encrypted)
    }

    /**
     * 복호화
     * 암호화된 Hex 코드 다시 원 문자로 변환
     *@param str 암호화된  헥사코드 문자열
     */
    fun decode(str: String): String {
        if (str.isEmpty()) {
            return ""
        }
        if (!isEncrypted(str)) {
            return str
        }
        val key = seedKey!!.toByteArray()
        val bszIV = bszivKey!!.toByteArray()

        val byteStr = hexStringToByteArray(str)

        val decrypted = byteStr.let { KisaSeedCbc.SEED_CBC_Decrypt(key, bszIV, byteStr, 0, byteStr.size) }

        return decrypted?.let { String(it) }!!
    }

    fun decodeWithReplaceChar(str: String, startIndex: Int, endIndex: Int, replaceChar: Char): String {
        val decode = decode(str)
        val replacement = replaceChar.toString().repeat(endIndex - startIndex)
        return decode.replaceRange(startIndex, endIndex, replacement)
    }

    /**
     * Seed 변환 Byte 를 Hex 코드로 변환
     * @param bytes KISA SEED 변환 데이터
     */
    private fun byteArrayToHexString(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (b in bytes) {
            sb.append(String.format("%02X", b.toInt() and 0xff))
        }
        return sb.toString()
    }

    /**
     * Hex 코드를 Seed Byte변환
     * @param encrypts 암호화 Hex코드
     */
    private fun hexStringToByteArray(encrypts: String): ByteArray {
        val len = encrypts.length
        val data = ByteArray(len / 2)
        var i = 0
        while (i < len) {
            data[i / 2] = ((Character.digit(encrypts[i], 16) shl 4) + Character.digit(encrypts[i + 1], 16)).toByte()
            i += 2
        }
        return data
    }

    /**
     * 암호화  데이터 체크
     * @param 'val' 암호화 문자열
     */
    private fun isEncrypted(`val`: CharSequence): Boolean {
        return `val`.length == 32 && `val`
            .toString()
            .matches("[0-9A-F]+".toRegex()) // 암호화되어있는경우 체크
    }
}
