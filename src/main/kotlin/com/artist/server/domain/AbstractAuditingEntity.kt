package com.artist.server.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

/**
 * Base abstract class for entities which will hold definitions for created, last modified by, created by,
 * last modified by attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@JsonIgnoreProperties(value = ["createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate"], allowGetters = true)
abstract class AbstractAuditingEntity(
    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 100, updatable = false)
    open var createdBy: String = "",

//    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    open var createdDate: ZonedDateTime = ZonedDateTime.now(),

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false, length = 100)
    open var lastModifiedBy: String = "",

//    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    open var lastModifiedDate: ZonedDateTime = ZonedDateTime.now(),

    @Column(name = "is_deleted")
    @ColumnDefault("false")
    open var isDeleted: Boolean? = false,
) : Serializable {

    @PrePersist
    fun prePersist() {
        createdDate = ZonedDateTime.now()
        lastModifiedDate = ZonedDateTime.now()
    }

    @PreUpdate
    fun preUpdate() {
        lastModifiedDate = ZonedDateTime.now()
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
