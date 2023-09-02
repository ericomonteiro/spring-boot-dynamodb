package com.ericomonteiro.github.com.dynamodb.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@RestController
@RequestMapping("/dynamodb")
class DynamoInfoController(
        private val dynamoDb: DynamoDbClient
) {

    @GetMapping("/tables")
    fun listTables(): MutableList<String>? {
        return dynamoDb.listTables().tableNames()
    }

}