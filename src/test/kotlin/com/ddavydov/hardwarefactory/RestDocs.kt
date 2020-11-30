package com.ddavydov.hardwarefactory

import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields
import org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.payload.RequestFieldsSnippet
import org.springframework.restdocs.payload.ResponseFieldsSnippet

fun getHardwareDoc(): ResponseFieldsSnippet {
    return relaxedResponseFields(
            fieldWithPath("content[]")
                    .description("content of hardware"),
            fieldWithPath("content[].id")
                    .description("identification"),
            fieldWithPath("content[].manufacturer")
                    .description("manifacturer"),
            fieldWithPath("content[].name")
                    .description("name"),
            fieldWithPath("content[].type")
                    .description("type"),
            fieldWithPath("content[].description")
                    .description("description"),
            fieldWithPath("content[].price")
                    .description("price"),
            fieldWithPath("content[].createdDate")
                    .description("createdDate"),
            fieldWithPath("content[].lastModifiedDate")
                    .description("lastModifiedDate")
    )
}

fun postHardwareRequestDoc(): RequestFieldsSnippet {
    return requestFields(
            fieldWithPath("id")
                    .description("identification")
                    .ignored(),
            fieldWithPath("manufacturer")
                    .description("manifacturer"),
            fieldWithPath("name")
                    .description("name"),
            fieldWithPath("type")
                    .description("type"),
            fieldWithPath("description")
                    .description("description"),
            fieldWithPath("price")
                    .description("price"),
            fieldWithPath("createdDate")
                    .description("createdDate"),
            fieldWithPath("lastModifiedDate")
                    .description("lastModifiedDate")
    )
}

fun postHardwareResponseDoc(): ResponseFieldsSnippet {
    return relaxedResponseFields(
            fieldWithPath("id")
                    .description("identification"),
            fieldWithPath("manufacturer")
                    .description("manifacturer"),
            fieldWithPath("name")
                    .description("name"),
            fieldWithPath("type")
                    .description("type"),
            fieldWithPath("description")
                    .description("description"),
            fieldWithPath("price")
                    .description("price"),
            fieldWithPath("createdDate")
                    .description("createdDate"),
            fieldWithPath("lastModifiedDate")
                    .description("lastModifiedDate")
    )
}