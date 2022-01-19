package com.example.product.vote.exception

import com.example.product.common.exception.AbstractBadRequestException

class VoteAlreadySubmittedException : AbstractBadRequestException() {
    override val code: String = "VOTE_ALREADY_SUBMITTED"

}
