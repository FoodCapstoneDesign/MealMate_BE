package io.junseok.dto

import lombok.Builder

@Builder
data class S3Response(
    val imageUrl: String,
    val fileName: String
){
}