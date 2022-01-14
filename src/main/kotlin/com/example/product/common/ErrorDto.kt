package com.example.product.common

data class ErrorDto(val message: String, val code: String) {

    private var error: Error? = null

    init {
        this.error = Error(message, code)
    }

    data class Error(
            val message: String,
            val code: String
    )
}