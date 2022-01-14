package com.example.product.product

import com.example.product.product.exception.ProductNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class DefaultProductService(private val productRepository: ProductRepository) : ProductService {
    override fun create(product: Product): Product {
        return productRepository.save(product);
    }

    override fun findById(id: Long): Product {
        return productRepository.findById(id).orElseThrow { throw ProductNotFoundException() }
    }

    override fun update(id: Long, data: Product): Product {
        val product = this.findById(id);
        if (data.name != null) {
            product.name = data.name;
        }
        if (data.description != null) {
            product.description = data.description;
        }
        if (data.price != null) {
            product.price = data.price;
        }
        return productRepository.save(product);
    }

    override fun delete(id: Long) {
        val product = this.findById(id);
        productRepository.delete(product);
    }

    override fun findAll(): Page<Product> {
        val pageable = PageRequest.of(0, 10);
        return productRepository.findAll(pageable);
    }
}