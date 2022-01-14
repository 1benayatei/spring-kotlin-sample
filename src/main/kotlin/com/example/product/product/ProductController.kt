package com.example.product.product

import com.example.product.common.*
import com.example.product.product.dto.ProductCreationDto
import com.example.product.product.dto.ProductDto
import com.example.product.product.dto.ProductUpdateDto
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ProductController(private val productService: ProductService) {

    @GetMapping(API_PRODUCT)
    @ResponseStatus(OK)
    fun index(): List<ProductDto> = productService.findAll().content.map { ProductDto().of(it) }

    @PostMapping(API_PRODUCT_CREATE)
    @ResponseStatus(CREATED)
    fun create(@Valid @RequestBody data: ProductCreationDto): ProductDto = ProductDto().of(productService.create(data.toProduct()))

    @GetMapping(API_PRODUCT_GET)
    @ResponseStatus(OK)
    fun get(@PathVariable id: Long): ProductDto = ProductDto().of(productService.findById(id))

    @PatchMapping(API_PRODUCT_UPDATE)
    @ResponseStatus(OK)
    fun update(@PathVariable id: Long, @Valid @RequestBody data: ProductUpdateDto): ProductDto = ProductDto().of(productService.update(id, data.toProduct()))

    @DeleteMapping(API_PRODUCT_DELETE)
    @ResponseStatus(NO_CONTENT)
    fun delete(@PathVariable id: Long) = productService.delete(id)
}
