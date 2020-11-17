package com.ddavydov.hardwarefactory.controller;

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
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
import javax.validation.Valid

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hardware")
class HardwareController(val hardwareService: HardwareService) {

    @GetMapping
    fun getHardware(@RequestParam(defaultValue = "0") page: Int): Page<HardwareDto> {
        return hardwareService.getHardware(page);
    }

    @GetMapping("/{hardwareId}")
    fun getHardwareById(@PathVariable hardwareId: UUID): HardwareDto {
        return hardwareService.getHardwareById(hardwareId);
    }

    @PostMapping
    fun saveHardware(@Valid @RequestBody hardware: HardwareDto): Hardware {
        return hardwareService.saveHardware(hardware);
    }

    @DeleteMapping("/{hardwareId}")
    fun deleteHardware(@PathVariable hardwareId: UUID) {
        return hardwareService.deleteHardware(hardwareId);
    }
}
