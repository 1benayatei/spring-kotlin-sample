package com.example.product.comment.dto

import com.example.product.comment.Comment
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import java.time.LocalDateTime

@JsonAutoDetect(fieldVisibility = ANY)
class CommentDto {
    private var id: Long = 0
    private var productId: Long = 0
    private var userId: Long = 0
    private var text: String = ""
    private var status: Comment.CommentStatus? = null;
    private var createdAt: LocalDateTime? = null
    private var updatedAt: LocalDateTime? = null

    fun of(comment: Comment): CommentDto {
        this.id = comment.id
        this.productId = comment.productId
        this.userId = comment.userId
        this.text = comment.text
        this.status = comment.status
        this.createdAt = comment.createdAt
        this.updatedAt = comment.updatedAt
        return this
    }
}
