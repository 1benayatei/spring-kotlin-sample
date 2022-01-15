package com.example.product.config.exception

import com.example.product.common.exception.AbstractBadRequestException

class ConfigExistsException : AbstractBadRequestException() {
    override val code: String = "CONFIG_EXISTS";
}
