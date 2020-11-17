package com.ddavydov.hardwarefactory.controller.dto;

import com.ddavydov.hardwarefactory.model.HardwareType
import java.util.*
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
        @field: Positive
        val price: Long
)
