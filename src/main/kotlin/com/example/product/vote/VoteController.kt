package com.example.product.vote

import com.example.product.common.API_VOTE_CREATE
import com.example.product.vote.dto.VoteCreationDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class VoteController(private val voteService: VoteService) {

    @PostMapping(API_VOTE_CREATE)
    fun createVote(@Valid @RequestBody data: VoteCreationDto) = voteService.create(data.toVote())
}