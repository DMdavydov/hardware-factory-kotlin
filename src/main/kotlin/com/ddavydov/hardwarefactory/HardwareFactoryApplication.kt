package com.ddavydov.hardwarefactory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HardwareFactoryApplication

fun main(args: Array<String>)  {
    runApplication<HardwareFactoryApplication>(*args)
}

