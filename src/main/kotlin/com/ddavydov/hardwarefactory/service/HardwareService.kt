package com.ddavydov.hardwarefactory.service;

import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.repositories.HardwareRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class HardwareService(val hardwareRepository: HardwareRepository) {

    fun getHardware(page: Int): Page<Hardware> {
        val pageable: Pageable = PageRequest.of(page, 5, Sort.by("name"))
        return hardwareRepository.findAll(pageable)
    }

    fun getHardwareById(id: UUID): Hardware {
        return hardwareRepository.findById(id)
                .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware Not Found") }
    }

    fun saveHardware(hardware: Hardware): Hardware {
        hardwareRepository.save(hardware)
        return hardware
    }

    fun deleteHardware(id: UUID) {
        hardwareRepository.deleteById(id)
    }
}
