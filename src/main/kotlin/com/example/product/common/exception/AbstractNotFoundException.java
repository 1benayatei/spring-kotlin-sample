package com.example.product.common.exception;

public abstract class AbstractNotFoundException extends AbstractException {
    @Override
    public int getStatus() {
        return 404;
    }
}
