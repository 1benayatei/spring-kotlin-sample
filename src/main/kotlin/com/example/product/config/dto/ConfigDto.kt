package com.example.product.config.dto

import com.example.product.config.Config
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import java.time.LocalDateTime

@JsonAutoDetect(fieldVisibility = ANY)
class ConfigDto {
    private var id: Long = 0
    private var visible: Boolean? = false
    private var commentable: Boolean? = false
    private var votable: Boolean? = false
    private var createdAt: LocalDateTime? = null
    private var updatedAt: LocalDateTime? = null

    fun of(config: Config): ConfigDto {
        this.id = config.id
        this.visible = config.visible
        this.commentable = config.commentable
        this.votable = config.votable
        this.createdAt = config.createdAt
        this.updatedAt = config.updatedAt
        return this
    }
}
