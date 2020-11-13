package com.ddavydov.hardwarefactory.converter;

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
import com.ddavydov.hardwarefactory.model.Hardware;
import com.ddavydov.hardwarefactory.model.HardwareType

class Converter {
    fun hardwareToDto(hardware: Hardware): HardwareDto {
        return HardwareDto(
                name = hardware.name,
                manufacturer = hardware.manufacturer,
                type = HardwareType.valueOf(hardware.type),
                description = hardware.description,
                price = hardware.price
        )
    }
}
