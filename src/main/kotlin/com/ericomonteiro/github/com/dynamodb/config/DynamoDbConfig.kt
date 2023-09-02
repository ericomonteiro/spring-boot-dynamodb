package com.ericomonteiro.github.com.dynamodb.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["com.ericomonteiro.github.com.dynamodb"])
class DynamoDbConfig (
    @Value("\${config.aws.region}")
    private val region: String,

    @Value("\${config.aws.dynamodb.url}")
    private val dynamoDbEndpointUrl: String,

    @Value("\${config.aws.dynamodb.access-key}")
    private val accessKey: String,

    @Value("\${config.aws.dynamodb.secret-key}")
    private val secretKey: String) {

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withEndpointConfiguration(getEndpointConfiguration(dynamoDbEndpointUrl))
                .build()
    }

    private fun getEndpointConfiguration(url: String): EndpointConfiguration {
        return EndpointConfiguration(url, region)
    }

    private val credentialsProvider: AWSStaticCredentialsProvider
        get() = AWSStaticCredentialsProvider(basicAWSCredentials)

    private val basicAWSCredentials: BasicAWSCredentials
        get() = BasicAWSCredentials(accessKey, secretKey)
}