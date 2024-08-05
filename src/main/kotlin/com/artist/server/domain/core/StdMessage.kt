package com.artist.server.domain.core

import com.artist.server.domain.AbstractAuditingEntity
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

/**
 * 공통메시지
 */
@Entity
@Table(name = "tbl_std_message")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdMessage(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /**
     * 메시지유형코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Column(name = "message_type_code", length = 25, nullable = false)
    var messageTypeCode: String? = null,

    /**
     * 메시지코드
     */
    @get: NotNull
    @get: Size(max = 25)
    @Column(name = "message_code", length = 25, nullable = false)
    var messageCode: String? = null,

    /**
     * 메시지내용
     */
    @get: NotNull
    @get: Size(max = 1000)
    @Column(name = "message_content", length = 1000, nullable = false)
    var messageContent: String? = null,

    /**
     * 정렬순서
     */
    @get: NotNull
    @Column(name = "sort_order", nullable = false)
    var sortOrder: Int? = null,

    /**
     * 활성화여부
     */
    @get: NotNull
    @Column(name = "is_activated", nullable = false)
    var isActivated: Boolean? = null,

    // jhipster-needle-entity-add-field - JHipster will add fields here
) : AbstractAuditingEntity(), Serializable {

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdMessage) return false
        return id != null && other.id != null && id == other.id
    }

    override fun toString(): String {
        return "StdMessage{" +
            "id=" + id +
            ", messageTypeCode='" + messageTypeCode + "'" +
            ", messageCode='" + messageCode + "'" +
            ", messageContent='" + messageContent + "'" +
            ", sortOrder=" + sortOrder +
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
