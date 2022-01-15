package com.example.product.config

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.PreUpdate

@Entity
data class Config(
    var visible: Boolean?,
    var commentable: Boolean?,
    var votable: Boolean?
) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = -1;
    var productId: Long = -1
    val createdAt = LocalDateTime.now()
    var updatedAt: LocalDateTime? = null

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}