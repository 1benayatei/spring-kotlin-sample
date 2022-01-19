package com.example.product.comment.dto

import com.example.product.comment.Comment
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull

data class CommentCreationDto(
    @field:NotNull
    @field:Length(min = 10, max = 255)
    val text: String,
    @field:NotNull
    val productId: Long,
    @field:NotNull
    val userId: Long
) {
    fun toComment(): Comment {
        return Comment(
            text = text,
            userId = userId,
            productId = productId,
        )
    }
}
