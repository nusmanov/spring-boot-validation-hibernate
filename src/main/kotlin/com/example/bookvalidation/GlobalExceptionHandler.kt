package com.example.bookvalidation

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolationException


@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {


    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    protected fun handleConflict(ex: RuntimeException?, request: WebRequest?): ResponseEntity<Any?>? {
        val bodyOfResponse = "This should be application specific"
        return handleExceptionInternal(ex!!, bodyOfResponse, HttpHeaders(), HttpStatus.CONFLICT, request!!)
    }

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun handleValidationExceptions(ex: ConstraintViolationException, request: WebRequest?): ResponseEntity<Any> {

        var errors = ""
        ex.constraintViolations.map { errors = it.message + " -- " + it.propertyPath }

        return handleExceptionInternal(ex, errors, HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request!!)

    }

}