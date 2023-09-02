package com.ericomonteiro.github.com.dynamodb.model

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
class CustomerSummary() {
    var id: String = ""
        @DynamoDbPartitionKey
        get() = field

    var name: String = ""
    constructor(id: String, name: String) : this() {
        this.id = id
        this.name = name
    }
    companion object {
        fun from(o: CustomerSummaryDto) =
            CustomerSummary(o.id, o.name)
    }
}