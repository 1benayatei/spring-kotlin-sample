package com.example.product.config;

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ConfigRepository : JpaRepository<Config, Long> {
    fun findByProductId(productId: Long): Optional<Config>
    fun existsByProductId(productId: Long): Boolean
}