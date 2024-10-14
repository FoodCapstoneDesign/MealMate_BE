package io.junseok.mealmateapi.base

import io.junseok.error.ErrorCode
import org.springframework.http.ResponseEntity

data class ErrorResponseEntity(
    val code: String,
    val message: String
)
fun ErrorCode.responseEntity(): ResponseEntity<ErrorResponseEntity> = ResponseEntity
    .status(this.status)
    .body(
        ErrorResponseEntity(
            code=this.name,
            message=this.message
        )
    )
