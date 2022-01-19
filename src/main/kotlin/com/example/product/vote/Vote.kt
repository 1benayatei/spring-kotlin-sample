package com.example.product.vote

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
data class Vote(
    var score: Byte,
    @Column(name = "product_id")
    var productId: Long = 0,
    var userId: Long? = null
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
    var createdAt: LocalDateTime = LocalDateTime.now();
    var updatedAt: LocalDateTime? = null;

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}