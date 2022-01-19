package com.example.product.comment

interface CommentService {
    fun create(comment: Comment): Comment;
    fun get(id: Long): Comment;
    fun update(id: Long, comment: Comment): Comment;
}