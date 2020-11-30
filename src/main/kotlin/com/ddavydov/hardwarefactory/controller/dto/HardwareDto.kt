package com.ddavydov.hardwarefactory.controller.dto;

import com.ddavydov.hardwarefactory.model.HardwareType
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class HardwareDto(
        val id: UUID? = null,
        @field: NotBlank
        val manufacturer: String,
        @field: NotBlank
        val name: String,
        @field: NotNull
        val type: HardwareType,
        @field: NotBlank
        val description: String,
        @field: JsonFormat(shape = JsonFormat.Shape.STRING)
        @field: Positive
        val price: Long,
        @field: JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
        val createdDate: ZonedDateTime? = null,
        @field: JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
        val lastModifiedDate: ZonedDateTime? = null
)
