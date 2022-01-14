package com.example.product.common.exception

abstract class AbstractException : RuntimeException() {
    abstract val code: String
    abstract val status: Int
}