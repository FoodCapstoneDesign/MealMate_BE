package io.junseok.mealmateapi.imagewrapper

import io.junseok.image.FileConversion
import org.springframework.web.multipart.MultipartFile

fun MultipartFile.toInputStreamFile()=
    FileConversion(
        inputStream = this.inputStream,
        contentType = this.contentType!!,
        contentLength = this.size
    )
