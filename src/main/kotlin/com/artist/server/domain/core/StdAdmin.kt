package com.artist.server.domain.core

import com.artist.server.domain.AbstractAuditingEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.BatchSize
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

/**
 * 어드민계정
 */
@Entity
@Table(name = "tbl_std_admin")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdAdmin(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /**
     * 어드민로그인아이디
     */
    @get: NotNull
    @get: Size(max = 100)
    @Column(name = "admin_login_id", length = 100, nullable = false)
    var adminLoginId: String = "",

    /**
     * 어드민비밀번호
     */
    @get: NotNull
    @get: Size(max = 255)
    @Column(name = "admin_password", length = 255, nullable = false)
    var adminPassword: String = "",

    /**
     * 어드민명
     */
    @get: NotNull
    @get: Size(max = 50)
    @Column(name = "admin_user_name", length = 50, nullable = false)
    var adminUserName: String = "",

    /**
     * 어드민연락처
     */
    @get: NotNull
    @get: Size(max = 30)
    @Column(name = "admin_phone_num", length = 30, nullable = false)
    var adminPhoneNum: String = "",

    /**
     * 어드민이메일
     */
    @get: NotNull
    @get: Size(max = 100)
    @Column(name = "admin_email", length = 100, nullable = false)
    var adminEmail: String = "",

    /**
     * 활성화여부
     */
    @get: NotNull
    @Column(name = "is_activated", nullable = false)
    var isActivated: Boolean = true,

    // jhipster-needle-entity-add-field - JHipster will add fields here
) : AbstractAuditingEntity(), Serializable {

    @ManyToMany
    @JoinTable(
        name = "tbl_std_admin_authority",
        joinColumns = [JoinColumn(name = "admin_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "authority_code_id", referencedColumnName = "id")]
    )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    var stdAuthorities: MutableSet<StdAuthority> = mutableSetOf()

    @OneToMany(mappedBy = "admin")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(
        value = [
            "admin",
        ],
        allowSetters = true
    )
    var stdAdminPasswords: MutableSet<StdAdminPassword>? = mutableSetOf()

    fun addStdAdminPassword(stdAdminPassword: StdAdminPassword): StdAdmin {
        this.stdAdminPasswords?.add(stdAdminPassword)
        stdAdminPassword.admin = this
        return this
    }

    fun removeStdAdminPassword(stdAdminPassword: StdAdminPassword): StdAdmin {
        this.stdAdminPasswords?.remove(stdAdminPassword)
        stdAdminPassword.admin = null
        return this
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdAdmin) return false
        return id != null && other.id != null && id == other.id
    }

    override fun toString(): String {
        return "StdAdmin{" +
            "id=" + id +
            ", adminLoginId='" + adminLoginId + "'" +
            ", adminPassword='" + adminPassword + "'" +
            ", adminUserName='" + adminUserName + "'" +
            ", adminPhoneNum='" + adminPhoneNum + "'" +
            ", adminEmail='" + adminEmail + "'" +
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
