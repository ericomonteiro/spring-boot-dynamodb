package com.ericomonteiro.github.com.dynamodb.service

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import com.ericomonteiro.github.com.dynamodb.model.CustomerSummary
import com.ericomonteiro.github.com.dynamodb.repository.CustomerSummaryRepository
import org.springframework.stereotype.Service

@Service
class CustomerSummaryService(
    private val customerSummaryRepository: CustomerSummaryRepository
) {

    fun createCustomerSummary(customerSummaryDto: CustomerSummaryDto): CustomerSummary {
        return customerSummaryRepository.save(CustomerSummary.from(customerSummaryDto))
    }

    fun listCustomersSummary(): List<CustomerSummary> {
        return customerSummaryRepository.findAll().toList()
    }

}