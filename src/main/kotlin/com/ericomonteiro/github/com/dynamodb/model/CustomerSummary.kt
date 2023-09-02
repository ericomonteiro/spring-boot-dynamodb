package com.ericomonteiro.github.com.dynamodb.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto

@DynamoDBTable(tableName = "my-app.customer_summary")
data class CustomerSummary(
    @DynamoDBHashKey
    val id: String,

    @DynamoDBAttribute
    val name: String
) {
    companion object {
        fun from(o: CustomerSummaryDto) =
            CustomerSummary(o.id, o.name)
    }
}