package com.example.product.vote.dto

import com.example.product.vote.Vote
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Max
import javax.validation.constraints.Min

data class VoteCreationDto(
    @field:NotNull
    @field:Min(1)
    @field:Max(10)
    val score: Byte,
    @field:NotNull
    val productId: Long,
    @field:NotNull
    val userId: Long
) {
    fun toVote(): Vote {
        return Vote(score, productId, userId)
    }
}
