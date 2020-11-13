package com.ddavydov.hardwarefactory.bootstrap

import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.model.HardwareType
import com.ddavydov.hardwarefactory.repositories.HardwareRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap(private val hardwareRepository: HardwareRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        loadHardware();
    }

    private fun loadHardware() {
        if (hardwareRepository.count() == 0L) {
            hardwareRepository.save(Hardware(
                    description = "test",
                    type = HardwareType.CPU.name,
                    name = "i9 10900k",
                    manufacturer = "INTEL",
                    price = 1000L)
            )

            hardwareRepository.save(Hardware(
                    description = "test1",
                    type = HardwareType.GRAPHIC_CARD.name,
                    name = "RTX 3090",
                    manufacturer = "EVGA",
                    price = 2000L)
            )

            hardwareRepository.save(Hardware(
                    description = "test1",
                    type = HardwareType.RAM.name,
                    name = "4000mhz 15CL",
                    manufacturer = "G.Skill",
                    price = 2000L)
            )

            hardwareRepository.save(Hardware(
                    description = "test1",
                    type = HardwareType.MOTHERBOARD.name,
                    name = "MSI pro",
                    manufacturer = "MSI",
                    price = 2000L)
            )

        }
    }
}