package com.ddavydov.hardwarefactory.converter;

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.model.HardwareType
import java.time.ZoneId
import java.time.ZonedDateTime

fun hardwareToDto(hardware: Hardware): HardwareDto {
    return HardwareDto(
            id = hardware.id,
            name = hardware.name,
            manufacturer = hardware.manufacturer,
            type = HardwareType.valueOf(hardware.type),
            description = hardware.description,
            price = hardware.price,
            lastModifiedDate = ZonedDateTime.ofInstant(hardware.lastModifiedDate?.toInstant(), ZoneId.of("UTC")),
            createdDate = ZonedDateTime.ofInstant(hardware.createdDate?.toInstant(), ZoneId.of("UTC"))
    )
}

