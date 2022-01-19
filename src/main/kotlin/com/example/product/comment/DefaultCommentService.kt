package com.example.product.comment

import com.example.product.comment.Comment.CommentStatus
import com.example.product.comment.exception.CommentAlreadyAcceptedException
import com.example.product.comment.exception.CommentAlreadyRejectedException
import com.example.product.comment.exception.CommentNotAllowedException
import com.example.product.comment.exception.CommentNotFoundException
import com.example.product.config.ConfigService
import org.springframework.stereotype.Service

@Service
class DefaultCommentService(
    private val commentRepository: CommentRepository,
    private val configService: ConfigService
) : CommentService {
    override fun create(comment: Comment): Comment {
        val config = configService.findByProductId(comment.productId!!);

        if (config.commentable == false) {
            throw CommentNotAllowedException()
        }

        return commentRepository.save(comment)
    }

    override fun get(id: Long): Comment {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, data: Comment): Comment {
        val comment = commentRepository.findById(id).orElseThrow { throw CommentNotFoundException() }

        when (comment.status) {
            CommentStatus.ACCEPTED -> {
                throw CommentAlreadyAcceptedException()
            }
            CommentStatus.REJECTED -> {
                throw CommentAlreadyRejectedException()
            }
            else -> {
                comment.status = data.status
                return commentRepository.save(comment)
            }
        }
    }
}