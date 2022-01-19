package com.example.product.comment.exception

import com.example.product.common.exception.AbstractBadRequestException

class CommentAlreadyAcceptedException : AbstractBadRequestException() {
    override val code: String = "COMMENT_ALREADY_ACCEPTED";

}
