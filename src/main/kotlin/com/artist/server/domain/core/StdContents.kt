package com.artist.server.domain.core

import com.artist.server.domain.AbstractAuditingEntity
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.*
import javax.validation.constraints.*

/**
 * 컨텐츠
 */
@Entity
@Table(name = "tbl_std_contents")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
data class StdContents(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    /**
     * 컨텐츠생성일시
     */
    @get: NotNull
    @Column(name = "contents_create_date", nullable = false)
    var contentsCreateDate: ZonedDateTime? = null,
    /**
     * 컨텐츠명
     */
    @get: NotNull
    @get: Size(max = 50)
    @Column(name = "contents_name", length = 50, nullable = false)
    var contentsName: String? = null,

    /**
     * 컨텐츠원본명
     */
    @get: NotNull
    @get: Size(max = 100)
    @Column(name = "contents_og_name", length = 100, nullable = false)
    var contentsOgName: String? = null,

    /**
     * 컨텐츠경로
     */
    @get: NotNull
    @get: Size(max = 100)
    @Column(name = "contents_path", length = 100, nullable = false)
    var contentsPath: String? = null,

    /**
     * 컨텐츠사이즈
     */
    @get: NotNull
    @Column(name = "contents_size", nullable = false)
    var contentsSize: Int? = null,

    /**
     * 컨텐츠유형
     */
    @get: NotNull
    @get: Size(max = 25)
    @Column(name = "contents_type", length = 25, nullable = false)
    var contentsType: String? = null,

    // jhipster-needle-entity-add-field - JHipster will add fields here
) : AbstractAuditingEntity(), Serializable {

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StdContents) return false
        return id != null && other.id != null && id == other.id
    }

    override fun toString(): String {
        return "StdContents{" +
            "id=" + id +
            ", contentsCreateDate='" + contentsCreateDate + "'" +
            ", contentsName='" + contentsName + "'" +
            ", contentsOgName='" + contentsOgName + "'" +
            ", contentsPath='" + contentsPath + "'" +
            ", contentsSize=" + contentsSize +
            ", contentsType='" + contentsType + "'" +
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
