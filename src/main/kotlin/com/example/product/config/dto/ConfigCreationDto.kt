package com.example.product.config.dto

import com.example.product.config.Config
import org.jetbrains.annotations.NotNull

data class ConfigCreationDto(
    @field:NotNull
    val productId: Long,
    @field:NotNull
    val visible: Boolean,
    @field:NotNull
    val commentable: Boolean,
    @field:NotNull
    val votable: Boolean,
) {
    fun toConfig(): Config {
        var config = Config(
            visible = visible,
            commentable = commentable,
            votable = votable
        )
        config.productId = productId
        return config;
    }
}