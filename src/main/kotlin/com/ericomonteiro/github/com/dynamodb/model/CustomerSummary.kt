package com.ericomonteiro.github.com.dynamodb.model

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import org.springframework.data.domain.Sort
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
class CustomerSummary() {
    var id: String = ""
        @DynamoDbPartitionKey
        get() = field

    var sortKey: String = ""
        @DynamoDbSortKey
        get() = field

    var name: String = ""
    constructor(id: String, sortKey: String, name: String) : this() {
        this.id = id
        this.sortKey = sortKey
        this.name = name
    }

    fun toInfoDto() =
        CustomerSummaryDto(
            this.id,
            this.name
        )

    companion object {
        fun from(o: CustomerSummaryDto) =
            CustomerSummary(o.id, SortKeys.INFO, o.name)
    }


    object SortKeys {
        const val INFO = "general"
    }
}