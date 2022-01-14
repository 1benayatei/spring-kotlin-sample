package com.example.product.product.exception

import com.example.product.common.exception.AbstractNotFoundException

class ProductNotFoundException : AbstractNotFoundException() {
    override val code: String = "PRODUCT_NOT_FOUND"
}