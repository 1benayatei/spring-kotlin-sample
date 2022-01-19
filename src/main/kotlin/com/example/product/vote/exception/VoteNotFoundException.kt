package com.example.product.vote.exception

import com.example.product.common.exception.AbstractNotFoundException

class VoteNotFoundException() : AbstractNotFoundException() {
    override val code: String = "VOTE_NOT_FOUND"

}
