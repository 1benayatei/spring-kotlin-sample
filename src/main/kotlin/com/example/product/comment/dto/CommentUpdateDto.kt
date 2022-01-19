package com.example.product.comment.dto

import com.example.product.comment.Comment
import org.jetbrains.annotations.NotNull

data class CommentUpdateDto(
    @field:NotNull
    val status: Comment.CommentStatus,
) {
    fun toComment(): Comment {
        return Comment(status);
    }
}
