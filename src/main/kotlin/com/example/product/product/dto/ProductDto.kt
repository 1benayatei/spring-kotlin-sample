package com.example.product.product.dto

import com.example.product.product.Product
import com.fasterxml.jackson.annotation.JsonAutoDetect
import java.time.LocalDateTime

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class ProductDto {
    private var id: Long = 0
    private var name: String? = null
    private var description: String? = null
    private var price: Double? = null
    private var createdAt: LocalDateTime? = null
    private var updatedAt: LocalDateTime? = null

    fun of(product: Product): ProductDto {
        this.id = product.id
        this.name = product.name
        this.description = product.description
        this.price = product.price
        this.createdAt = product.createdAt
        this.updatedAt = product.updatedAt
        return this
    }
}
