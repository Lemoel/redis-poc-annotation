package com.poc.redis.annotation.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.IllegalStateException

@ControllerAdvice
class GlobalHandlerException {

    @ExceptionHandler(IllegalStateException::class)
    fun handleExternalResponseErrorException(
        exception: IllegalStateException
    ): ResponseEntity<ResponseError> = status(HttpStatus.BAD_REQUEST).body(
        ResponseError(
            status = HttpStatus.BAD_REQUEST.value(), errors = listOf(
                ErrorDetail(
                    errorCode = HttpStatus.BAD_REQUEST.toString(), message = exception.localizedMessage
                )
            )
        )
    )
}
