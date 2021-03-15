package com.ddavydov.hardwarefactory.exceptions

import javax.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class HardwareExceptionAdvice : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ConstraintViolationException::class)
    fun validationException(exception: ConstraintViolationException): ResponseEntity<MutableSet<String>> {
        val errors: MutableSet<String> = mutableSetOf()
        exception.constraintViolations
            .forEach {
                errors.add((it.propertyPath + " : " + it.message).toString())
            }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}