package com.ericomonteiro.github.com.dynamodb.service

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import com.ericomonteiro.github.com.dynamodb.model.CustomerSummary
import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Service

@Service
class CustomerSummaryService(
    private val dynamoDbTemplate: DynamoDbTemplate
) {

    fun createCustomerSummary(customerSummaryDto: CustomerSummaryDto): CustomerSummary {
        return dynamoDbTemplate.save(CustomerSummary.from(customerSummaryDto))
    }

    fun listCustomersSummary(): List<CustomerSummary> {
        return emptyList()
    }

}