package com.ericomonteiro.github.com.dynamodb.controller

import com.ericomonteiro.github.com.dynamodb.dto.CustomerSummaryDto
import com.ericomonteiro.github.com.dynamodb.model.CustomerSummary
import com.ericomonteiro.github.com.dynamodb.service.CustomerSummaryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customer-summary")
class CustomerSummaryController(
    private val customerSummaryService: CustomerSummaryService
) {

    @PostMapping
    fun createCustomer(@RequestBody dto: CustomerSummaryDto): CustomerSummary {
        return customerSummaryService.createCustomerSummary(dto)
    }

    @GetMapping
    fun listCustomers() = customerSummaryService.listCustomersSummary()
}