package com.ddavydov.hardwarefactory.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException
import javax.validation.ConstraintViolationException

@ControllerAdvice
class HardwareExceptionAdvice {

    @ExceptionHandler(ConstraintViolationException::class)
    fun validationException(exception: ConstraintViolationException): ResponseEntity<MutableSet<String>> {
        val errors: MutableSet<String> = mutableSetOf()
        exception.constraintViolations
                .forEach {
                    errors.add((it.propertyPath + " : " + it.message).toString())
                }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BindException::class)
    fun bindException(exception: BindException): ResponseEntity<MutableList<ObjectError>> {
        return ResponseEntity(exception.allErrors, HttpStatus.BAD_REQUEST)
    }
}