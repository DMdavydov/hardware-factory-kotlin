package com.ddavydov.hardwarefactory.model;

import com.ddavydov.hardwarefactory.annotations.NoArgs
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import org.hibernate.annotations.Type

@Entity
@NoArgs
class Hardware(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Type(type="org.hibernate.type.UUIDCharType")
        @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
        val id: UUID? = null,
        val manufacturer: String,
        @Column(unique = true)
        val name: String,
        val type: String,
        val description: String,
        val price: Long,
        @CreationTimestamp
        val createdDate: Timestamp? = null,
        @UpdateTimestamp
        val lastModifiedDate: Timestamp? = null
)