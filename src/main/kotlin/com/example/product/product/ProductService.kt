package com.example.product.product

import org.springframework.data.domain.Page


interface ProductService {
    fun create(product: Product): Product;
    fun findById(id: Long): Product;
    fun update(id: Long, product: Product): Product;
    fun delete(id: Long);
    fun findAll(): Page<Product>
}