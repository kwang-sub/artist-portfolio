package com.artist.server.constant

class StdConstants {
    companion object {
        const val MSG_YOU_ARE_NOT_AUTHORIZED = "권한이 없습니다."
        const val MSG_ADMIN_NOT_FOUND = "어드민 정보를 찾을 수 없습니다."
        const val MSG_AUTHORITY_NOT_FOUND = "권한 정보를 찾을 수 없습니다."
        const val MSG_DUPLICATE_LOGIN_ID = "로그인 아이디는 중복될 수 없습니다."
        const val MSG_NOT_EQUALS_RESET_PASSWORD = "비밀번호가 일치하지 않습니다. 다시 확인해주세요."
        const val MSG_REQUIRE_FILED = "{} 은 필수 값입니다."
        const val MSG_ADMIN_NAME_INVALID = "어드민명이 유효하지 않습니다. (검증값 : \${validatedValue}, 유효성 : {invalidWord})"
    }
}

class SuvConstants {
    companion object {
        // something TODO
    }
}

class HopConstants {
    companion object {
        const val MSG_HOSPITAL_NOT_FOUND = "병원 정보를 찾을 수 없습니다."
        const val MSG_HOSPITAL_PATIENTS_EXIST = "병원 환자 정보가 존재하여 삭제 할수 없습니다."
        const val MSG_HOSPITAL_DEPARTMENTS_EXIST = "병원 진료과 정보가 존재하여 삭제 할수 없습니다."
    }
}

class UsrConstants {
    companion object {
        const val MSG_PATIENT_NOT_FOUND = "환자 정보를 찾을 수 없습니다."
        const val MSG_DOCTOR_NOT_FOUND = "의사 정보를 찾을 수 없습니다."
        const val MSG_DUPLICATE_PATIENT_LOGIN_ID = "환자 로그인 아이디는 중복될 수 없습니다."
        const val MSG_DUPLICATE_PATIENT_RN = "환자 주민번호는 중복될 수 없습니다."
        const val MSG_ALREADY_EXIST_PATIENT_LOGIN_ID = "환자 로그인 아이디가 사용중입니다."
        const val MSG_ALREADY_EXIST_PATIENT_RN = "환자 주민번호가 사용중입니다."
        const val MSG_PATIENT_EXIST = "병원 진료과가 존재하여 삭제 할수 없습니다."
        const val MSG_SURVEY_SEND_ALM_HISTORY_EXIST = "환자 알림톡 전송내역이 존재 하여 삭제 할수 없습니다."
    }
}

class CusConstants {
    companion object {
        // something TODO
    }
}
