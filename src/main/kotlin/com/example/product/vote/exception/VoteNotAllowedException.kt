package com.example.product.vote.exception

import com.example.product.common.exception.AbstractBadRequestException

class VoteNotAllowedException : AbstractBadRequestException() {
    override val code: String = "VOTE_NOT_ALLOWED"

}
