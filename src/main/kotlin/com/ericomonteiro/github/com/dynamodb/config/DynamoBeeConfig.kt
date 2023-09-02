package com.ericomonteiro.github.com.dynamodb.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.github.dynamobee.Dynamobee
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoBeeConfig(
        private val db: AmazonDynamoDB
) {

    @Bean
    fun dynamoBee(): Dynamobee {
        val runner = Dynamobee(db)
        runner.setChangeLogsScanPackage(
                "com.ericomonteiro.github.com.dynamodb.model.migration") // the package to be scanned for changesets
        return runner
    }

}