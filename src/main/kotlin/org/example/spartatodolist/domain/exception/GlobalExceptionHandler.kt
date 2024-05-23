package org.example.spartatodolist.domain.exception

import org.example.spartatodolist.domain.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ModelNotFoundException::class)
    fun handleModelNotFoundException(e:ModelNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(message=e.message))
    }


    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(e:IllegalStateException):ResponseEntity<ErrorResponse>{
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse(e.message))
    }

    @ExceptionHandler(IncorrectPasswordException::class)
    fun handleIncorrectPasswordException(e:IncorrectPasswordException):ResponseEntity<ErrorResponse>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse(e.message))
    }
}