package io.junseok.image

import java.io.InputStream

data class FileConversion(
    val inputStream: InputStream,
    val contentType:String,
    val contentLength: Long
)
