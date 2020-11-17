package com.ddavydov.hardwarefactory.converter;

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
import com.ddavydov.hardwarefactory.model.Hardware;
import com.ddavydov.hardwarefactory.model.HardwareType

fun hardwareToDto(hardware: Hardware): HardwareDto {
    return HardwareDto(
            id = hardware.id,
            name = hardware.name,
            manufacturer = hardware.manufacturer,
            type = HardwareType.valueOf(hardware.type),
            description = hardware.description,
            price = hardware.price
    )
}

