package com.ddavydov.hardwarefactory.repositories;

import com.ddavydov.hardwarefactory.model.Hardware
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.*

interface HardwareRepository : PagingAndSortingRepository<Hardware, UUID> {

}
