package com.example.product.product.dto

import com.example.product.product.Product
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class ProductCreationDto(

        @field:NotNull
        @field:Length(min = 5, max = 50)
        val name: String,

        @field:Min(1000)
        @field:Max(100000)
        val price: Double,

        @field:NotNull
        @field:Length(min = 10, max = 255)
        val description: String) {
    fun toProduct(): Product {
        return Product(name, price, description)
    }
}
