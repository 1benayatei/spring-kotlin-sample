package com.example.product.config

interface ConfigService {
    fun create(config: Config): Config;
    fun update(id: Long, data: Config): Config;
    fun findById(id: Long): Config;
}