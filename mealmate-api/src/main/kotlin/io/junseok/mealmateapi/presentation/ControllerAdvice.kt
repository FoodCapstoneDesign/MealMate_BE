package io.junseok.mealmateapi.presentation

import io.junseok.error.MealMateException
import io.junseok.mealmateapi.base.ErrorResponseEntity
import io.junseok.mealmateapi.base.responseEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(MealMateException::class)
    protected fun errorCodeResponseEntity(ex: MealMateException): ResponseEntity<ErrorResponseEntity> =
        ex.errorCode.responseEntity()
}