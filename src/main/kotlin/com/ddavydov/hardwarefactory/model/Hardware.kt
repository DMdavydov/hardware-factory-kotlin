package com.ddavydov.hardwarefactory.model

import com.ddavydov.hardwarefactory.annotations.NoArgs
import java.sql.Timestamp
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.hibernate.annotations.UpdateTimestamp

@Entity
@NoArgs
class Hardware(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    val id: UUID? = null,
    val manufacturer: String,
    @Column(unique = true)
    val name: String,
    @Enumerated(EnumType.STRING)
    val type: HardwareType,
    val description: String,
    val price: Long,
    @CreationTimestamp
    val createdDate: Timestamp? = null,
    @UpdateTimestamp
    val lastModifiedDate: Timestamp? = null
)