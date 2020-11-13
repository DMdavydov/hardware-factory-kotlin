package com.ddavydov.hardwarefactory.controller;

import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.service.HardwareService
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hardware")
class HardwareController(val hardwareService: HardwareService) {

    @GetMapping
    fun getHardware(@RequestParam(defaultValue = "0") page: Int): Page<Hardware> {
        return hardwareService.getHardware(page);
    }

    @GetMapping("/{hardwareId}")
    fun getHardwareById(@PathVariable hardwareId: UUID): Hardware {
        return hardwareService.getHardwareById(hardwareId);
    }

    @PostMapping
    fun saveHardware(@RequestBody hardware: Hardware): Hardware {
        return hardwareService.saveHardware(hardware);
    }

    @DeleteMapping("/{hardwareId}")
    fun deleteHardware(@PathVariable hardwareId: UUID) {
        return hardwareService.deleteHardware(hardwareId);
    }
}
