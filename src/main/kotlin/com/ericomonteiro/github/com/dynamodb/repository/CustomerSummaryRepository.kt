package com.ericomonteiro.github.com.dynamodb.repository

import com.ericomonteiro.github.com.dynamodb.model.CustomerSummary
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerSummaryRepository : CrudRepository<CustomerSummary, String>