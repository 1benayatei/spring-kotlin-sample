package com.example.product.comment.exception

import com.example.product.common.exception.AbstractNotFoundException

class CommentNotFoundException : AbstractNotFoundException() {
    override val code: String = "COMMENT_NOT_FOUND";

}
