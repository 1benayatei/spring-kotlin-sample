package com.example.product.comment.exception

import com.example.product.common.exception.AbstractBadRequestException

class CommentNotAllowedException : AbstractBadRequestException() {
    override val code: String = "COMMENT_NOT_ALLOWED";

}
