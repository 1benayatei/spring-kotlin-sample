package com.example.product.product.aspect

import com.example.product.config.Config
import com.example.product.config.ConfigService
import com.example.product.product.Product
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Async

@Aspect
@Configuration
class ProductService(private val configService: ConfigService) {
    @Pointcut("execution(* com.example.product.product.ProductService.create(..))")
    fun create() {
    }

    @AfterReturning(pointcut = "create()", returning = "product")
    @Async
    fun afterReturningCreateProduct(joinPoint: JoinPoint, product: Product) {
        val config = Config(visible = true, commentable = true, votable = true);
        config.productId = product.id;
        configService.create(config);
    }
}