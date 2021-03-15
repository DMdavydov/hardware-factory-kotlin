package com.ddavydov.hardwarefactory.repositories

import com.ddavydov.hardwarefactory.model.Hardware
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface HardwareRepository : JpaRepository<Hardware, UUID>
