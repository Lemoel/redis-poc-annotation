package com.poc.redis.annotation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class AnnotationApplication

fun main(args: Array<String>) {
	runApplication<AnnotationApplication>(*args)
}
