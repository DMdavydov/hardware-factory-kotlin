package com.ddavydov.hardwarefactory.service

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
import com.ddavydov.hardwarefactory.converter.hardwareToDto
import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.repositories.HardwareRepository
import java.util.UUID
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class HardwareService(val hardwareRepository: HardwareRepository) {

    fun getHardware(page: Int): Page<HardwareDto> {
        val pageable: Pageable = PageRequest.of(page, 5, Sort.by("name"))
        return hardwareRepository.findAll(pageable)
            .map { hardwareToDto(it) }
    }

    fun getHardwareById(id: UUID): HardwareDto {
        return hardwareRepository.findById(id).map { hardwareToDto(it) }
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware Not Found") }
    }

    fun saveHardware(hardwareDto: HardwareDto): Hardware {
        val hardware = Hardware(
            name = hardwareDto.name,
            manufacturer = hardwareDto.manufacturer,
            type = hardwareDto.type,
            description = hardwareDto.description,
            price = hardwareDto.price
        )
        hardwareRepository.save(hardware)
        return hardware
    }

    fun deleteHardware(id: UUID) {
        hardwareRepository.deleteById(id)
    }
}
