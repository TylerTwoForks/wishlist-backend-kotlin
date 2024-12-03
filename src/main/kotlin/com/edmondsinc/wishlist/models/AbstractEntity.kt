package com.edmondsinc.wishlist.models

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
abstract class AbstractEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, unique = true)
    val id: Long = 0L,

    @Column(name = "guid", nullable = false, unique = true, updatable = false)
    val guid: UUID = UUID.randomUUID(),

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    override fun toString(): String {
        return "AbstractEntity(id=$id, guid=$guid, createdAt=$createdAt)"
    }
}
