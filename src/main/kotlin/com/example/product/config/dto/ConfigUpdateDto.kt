package com.example.product.config.dto

import com.example.product.config.Config

data class ConfigUpdateDto(
    val visible: Boolean?,
    val commentable: Boolean?,
    val votable: Boolean?,
) {
    fun toConfig(): Config {
        return Config(
            visible = visible,
            commentable = commentable,
            votable = votable
        )
    }
}