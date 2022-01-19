package com.example.product.vote

import com.example.product.config.ConfigService
import com.example.product.vote.exception.VoteAlreadySubmittedException
import com.example.product.vote.exception.VoteNotAllowedException
import com.example.product.vote.exception.VoteNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class DefaultVoteService(
    private val voteRepository: VoteRepository,
    private val configService: ConfigService
) : VoteService {

    override fun create(vote: Vote): Vote {
        val productConfig = configService.findByProductId(vote.productId);

        if (productConfig.votable == false) {
            throw VoteNotAllowedException();
        }

        try {
            return voteRepository.save(vote);
        } catch (e: DataIntegrityViolationException) {
            throw VoteAlreadySubmittedException();
        }
    }

    override fun get(id: Long): Vote {
        return voteRepository.findById(id).orElseThrow {
            throw VoteNotFoundException()
        }
    }
}