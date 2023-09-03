package com.ericomonteiro.github.com.dynamodb.service

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import com.ericomonteiro.github.com.dynamodb.dto.PageWrapper
import com.ericomonteiro.github.com.dynamodb.model.CustomerSummary
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Service
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

@Service
class CustomerSummaryService(
    private val dynamoDbTemplate: DynamoDbTemplate
) {

    fun createCustomerSummary(customerSummaryDto: CustomerSummaryDto): CustomerSummaryDto {
        return dynamoDbTemplate.save(CustomerSummary.from(customerSummaryDto)).toInfoDto()
    }

    fun listCustomersSummary(pageSize: Int, lastResult: String): PageWrapper<CustomerSummaryDto> {
        val result = dynamoDbTemplate.scan(
            ScanEnhancedRequest
                .builder()
                .limit(pageSize)
                .apply {
                    if (lastResult.isNotBlank()) {
                        exclusiveStartKey(
                            mapOf(
                                "id" to AttributeValue.builder().s(lastResult).build(),
                                "sortKey" to AttributeValue.builder().s("general").build()
                            )
                        )
                    }
                }.build(),

            CustomerSummary::class.java
        ).first()



        return PageWrapper.from(
            result.items().map { customerSummary -> customerSummary.toInfoDto() },
            result.lastEvaluatedKey()["id"]?.s() ?: "")
    }
}

