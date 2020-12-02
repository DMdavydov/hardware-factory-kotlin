package com.ddavydov.hardwarefactory.controller

import com.ddavydov.hardwarefactory.controller.dto.HardwareDto
import com.ddavydov.hardwarefactory.getHardwareDoc
import com.ddavydov.hardwarefactory.model.Hardware
import com.ddavydov.hardwarefactory.model.HardwareType
import com.ddavydov.hardwarefactory.postHardwareRequestDoc
import com.ddavydov.hardwarefactory.postHardwareResponseDoc
import com.ddavydov.hardwarefactory.repositories.HardwareRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.whenever
import java.sql.Timestamp
import java.time.Instant
import java.util.Optional
import java.util.UUID
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
@ExtendWith(RestDocumentationExtension::class)
class HardwareControllerTest {

    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @MockBean
    lateinit var hardwareRepository: HardwareRepository

    @BeforeEach
    fun setUp(webApplicationContext: WebApplicationContext?,
              restDocumentation: RestDocumentationContextProvider?) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext!!)
                .apply<DefaultMockMvcBuilder>(documentationConfiguration(restDocumentation))
                .build()
    }

    val pageable: Pageable = PageRequest.of(0, 5, Sort.by("name"))

    val hardware = HardwareDto(
            description = "test",
            type = HardwareType.CPU,
            name = "test",
            manufacturer = "INTEL",
            price = 1000L
    )

    val hardwaree = Hardware(
            id = UUID.randomUUID(),
            description = "test",
            type = HardwareType.CPU.name,
            name = "test",
            manufacturer = "INTEL",
            price = 1000L,
            createdDate = Timestamp.from(Instant.now()),
            lastModifiedDate = Timestamp.from(Instant.now())
    )

    var pagedResponse: Page<Hardware> = PageImpl<Hardware>(mutableListOf(hardwaree))

    @Test
    fun getHardware() {
        whenever(hardwareRepository.findAll(pageable)).thenReturn(pagedResponse)
        val response = mockMvc.perform(get("/api/v1/hardware"))

        response
                .andExpect(status().is2xxSuccessful)
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("get-hardware",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        getHardwareDoc()
                ))
    }

    @Test
    fun getHardwareById() {
        whenever(hardwareRepository.findById(any())).thenReturn(Optional.of(hardwaree))
        val response = mockMvc.perform(get("/api/v1/hardware/{id}", UUID.randomUUID()))

        response
                .andExpect(status().is2xxSuccessful)
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("get-hardware-by-id",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        postHardwareResponseDoc()
                ))
    }

    @Test
    fun saveHardware() {
        val response = mockMvc.perform(post("/api/v1/hardware")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(hardware))
        )

        response
                .andExpect(status().is2xxSuccessful)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.name", equalTo("test")))
                .andDo(document("post-hardware",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        postHardwareRequestDoc(),
                        postHardwareResponseDoc()
                ))
    }

    @Test
    fun deleteHardware() {
        doNothing().`when`(hardwareRepository).deleteById(any())
        val response = mockMvc.perform(delete("/api/v1/hardware/{id}", UUID.randomUUID()))

        response
                .andExpect(status().is2xxSuccessful)
                .andDo(MockMvcResultHandlers.print())
                .andDo(document("delete-hardware",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                ))
    }
}