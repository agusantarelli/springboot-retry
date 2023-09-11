package com.example.springbootretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class SpringbootRetryApplication

fun main(args: Array<String>) {
	runApplication<SpringbootRetryApplication>(*args)
}
