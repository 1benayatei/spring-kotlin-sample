package com.example.product.common

import com.example.product.common.exception.AbstractException
import org.springframework.context.support.MessageSourceAccessor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandling(var messageSourceAccessor: MessageSourceAccessor) {
    @ExceptionHandler(AbstractException::class)
    fun handleAbstractExceptions(e: AbstractException): ResponseEntity<ErrorDto> {
        val code: String = e.code
        var message = "";
        message = try {
            messageSourceAccessor.getMessage(code)
        } catch (e: Exception) {
            code;
        }
        val error = ErrorDto(message, code)
        val httpStatus: HttpStatus = HttpStatus.valueOf(e.status)
        return ResponseEntity.status(httpStatus).body(error)
    }
}