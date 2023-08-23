package com.ericomonteiro.github.com.dynamodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DynamodbApplication

fun main(args: Array<String>) {
	runApplication<DynamodbApplication>(*args)
}
