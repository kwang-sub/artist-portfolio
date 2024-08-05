package com.artist.server.domain.core

import com.artist.server.domain.AbstractAuditingEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

/**
 * 어드민권한관계
 */
@Entity
@Table(name = "tbl_std_admin_authority")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdminAuthority(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
) : AbstractAuditingEntity(), Serializable {

    /**
     * 권한코드
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "authority_code_id", nullable = false)
    @NotNull
    @JsonIgnoreProperties(
        value = [
            "stdAdminAuthorities",
            "stdMenuAuthorities",
        ],
        allowSetters = true
    )
    var authorityCode: StdAuthority? = null

    /**
     * 어드민ID
     */
    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(
        value = [
            "adminLoginId",
            "adminPassword",
            "adminUserName",
            "adminPhoneNum",
            "adminEmail",
            "adminSignImageId",
            "isActivated",
            "isDeleted",
            "createdBy",
            "createdDate",
            "lastModifiedBy",
            "lastModifiedDate",
        ],
        allowSetters = true
    )
    var admin: StdAdmin? = null

    fun authorityCode(stdAuthority: StdAuthority?): StdAdminAuthority {
        this.authorityCode = stdAuthority
        return this
    }

    fun stdAdmin(stdAdmin: StdAdmin?): StdAdminAuthority {
        this.admin = stdAdmin
        return this
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdAdminAuthority) return false
        return id != null && other.id != null && id == other.id
    }

    override fun toString(): String {
        return "StdAdminAuthority{" +
            "id=" + id +
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
