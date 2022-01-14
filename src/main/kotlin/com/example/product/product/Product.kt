package com.example.product.product

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Product(
        var name: String?,
        var price: Double?,
        var description: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1;


    val createdAt: LocalDateTime = LocalDateTime.now();
    var updatedAt: LocalDateTime? = null;

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}