package com.example.product.comment

import com.example.product.comment.dto.CommentCreationDto
import com.example.product.comment.dto.CommentDto
import com.example.product.comment.dto.CommentUpdateDto
import com.example.product.common.API_COMMENT_CREATE
import com.example.product.common.API_COMMENT_UPDATE
import org.springframework.http.HttpStatus.ACCEPTED
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class CommentController(private val commentService: CommentService) {
    @PostMapping(API_COMMENT_CREATE)
    @ResponseStatus(CREATED)
    fun create(@Valid @RequestBody data: CommentCreationDto) = CommentDto().of(commentService.create(data.toComment()));

    @PatchMapping(API_COMMENT_UPDATE)
    @ResponseStatus(ACCEPTED)
    fun update(@PathVariable id: Long, @Valid @RequestBody data: CommentUpdateDto) =
        CommentDto().of(commentService.update(id, data.toComment()));
}