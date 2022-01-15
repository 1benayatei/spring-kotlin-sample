package com.example.product.config.exception

import com.example.product.common.exception.AbstractNotFoundException

class ConfigNotFoundException : AbstractNotFoundException() {
    override val code: String = "CONFIG_NOT_FOUND";
}
