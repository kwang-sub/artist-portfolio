package com.artist.server.domain.core

import com.artist.server.domain.AbstractAuditingEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

/**
 * 공통코드
 */
@Entity
@Table(name = "tbl_std_common_code")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdCommonCode(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /**
     * 공통코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Column(name = "common_code", length = 25, nullable = false)
    var commonCode: String? = null,

    /**
     * 공통코드명
     */
    @get: NotNull
    @get: Size(max = 50)
    @Column(name = "common_code_name", length = 50, nullable = false)
    var commonCodeName: String? = null,

    /**
     * 공통코드설명
     */
    @get: Size(max = 255)
    @Column(name = "common_code_desc", length = 255)
    var commonCodeDesc: String? = null,

    /**
     * 정렬순서
     */
    @get: NotNull
    @Column(name = "sort_num", nullable = false)
    var sortNum: Int? = null,

    /**
     * 활성화여부
     */
    @get: NotNull
    @Column(name = "is_activated", nullable = false)
    var isActivated: Boolean? = null,

    // jhipster-needle-entity-add-field - JHipster will add fields here
) : AbstractAuditingEntity(), Serializable {

    /**
     * 공통그룹코드
     */
    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(
        value = [
            "stdCommonCodes",
        ],
        allowSetters = true
    )
    var commonGroupCode: StdCommonGroupCode? = null

    fun commonGroupCode(stdCommonGroupCode: StdCommonGroupCode?): StdCommonCode {
        this.commonGroupCode = stdCommonGroupCode
        return this
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdCommonCode) return false
        return id != null && other.id != null && id == other.id
    }

    override fun toString(): String {
        return "StdCommonCode{" +
            "id=" + id +
            ", commonCode='" + commonCode + "'" +
            ", commonCodeName='" + commonCodeName + "'" +
            ", commonCodeDesc='" + commonCodeDesc + "'" +
            ", sortNum=" + sortNum +
            ", isActivated='" + isActivated + "'" +
            ", isDeleted='" + isDeleted + "'" +
            ", createdBy='" + createdBy + "'" +
            ", createdDate='" + createdDate + "'" +
            ", lastModifiedBy='" + lastModifiedBy + "'" +
            ", lastModifiedDate='" + lastModifiedDate + "'" +
            "}"
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
