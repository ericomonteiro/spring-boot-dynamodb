package com.ericomonteiro.github.com.dynamodb.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "")
data class CustomerSummary(
    private val id: String
)