package com.example.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableAsync
class ProductApplication

fun main(args: Array<String>) {
	runApplication<ProductApplication>(*args)
}
