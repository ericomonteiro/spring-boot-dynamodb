package com.ericomonteiro.github.com.dynamodb.model.migration

import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Table
import com.amazonaws.services.dynamodbv2.model.*
import com.github.dynamobee.changeset.ChangeLog
import com.github.dynamobee.changeset.ChangeSet


@ChangeLog
class CustomerSummaryMigration {

    private val tableName: String = "my-app.customer_summary"

    @ChangeSet(author = "erico monteiro", id = "835f8a22-41c6-11ee-be56-0242ac120002", order = "0001")
    fun createTable(db: DynamoDB) {
        val attributeDefinitions: MutableList<AttributeDefinition> = ArrayList()
        attributeDefinitions.add(AttributeDefinition().withAttributeName("id").withAttributeType("S"))
        attributeDefinitions.add(AttributeDefinition().withAttributeName("sortKey").withAttributeType("S"))
        val keySchema: MutableList<KeySchemaElement> = ArrayList()
        keySchema.add(KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH))
        keySchema.add(KeySchemaElement().withAttributeName("sortKey").withKeyType(KeyType.RANGE))

        val request = CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(ProvisionedThroughput()
                        .withReadCapacityUnits(5L)
                        .withWriteCapacityUnits(6L))

        val table: Table = db.createTable(request)

        table.waitForActive()
    }

}