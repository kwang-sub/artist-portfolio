package com.artist.server.kstarter.web.rest.std

import com.artist.server.domain.core.StdAuthority
import com.artist.server.kstarter.IntegrationTest
import com.artist.server.kstarter.web.rest.WithAuthenticatedMockUser
import com.artist.server.kstarter.web.rest.convertObjectToJsonBytes
import com.artist.server.repository.std.AdminRepository
import com.artist.server.service.std.dto.AdminSaveReqDTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class AdminResourceTest {

    @Autowired
    private lateinit var restStdAdminMockMvc: MockMvc

    @Autowired
    private lateinit var adminRepository: AdminRepository

    private val ENTITY_API_URL: String = "/api/v1/std-admins"

    @Test
    @WithAuthenticatedMockUser(username = "admin", password = "admin", role = StdAuthority.CODE_AUTHORITY_ADMIN)
    fun 환자목록조회경로테스트() {
        restStdAdminMockMvc
            .perform(
                MockMvcRequestBuilders.get(ENTITY_API_URL)
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @WithAuthenticatedMockUser(username = "admin", password = "admin", role = StdAuthority.CODE_AUTHORITY_ADMIN)
    fun 환자등록테스트() {

        val stdAdminDTO = AdminSaveReqDTO(
            adminEmail = "kwang@weedscomm.com",
            adminLoginId = "kwang11",
            adminPassword = "kwang",
            adminPhoneNum = "010895579994",
            adminUserName = "최광섭"
        )

        restStdAdminMockMvc
            .perform(
                MockMvcRequestBuilders.post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(convertObjectToJsonBytes(stdAdminDTO))
            )
            .andExpect(MockMvcResultMatchers.status().isCreated)

        val admin =
            adminRepository.findByAdminUserNameEqualsAndIsDeletedFalse("최광섭")
                .orElseThrow { Exception("asdf") }

        assertThat(admin).isNotNull
        assertThat(admin.adminUserName).isEqualTo("최광섭")
    }
}
