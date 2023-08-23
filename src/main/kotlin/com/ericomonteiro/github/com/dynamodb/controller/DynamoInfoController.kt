package com.ericomonteiro.github.com.dynamodb.controller

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dynamodb")
class DynamoInfoController(
        private val dynamoDb: AmazonDynamoDB
) {

    @GetMapping("/tables")
    fun listTables(): MutableList<String>? {
        return dynamoDb.listTables().tableNames
    }

}