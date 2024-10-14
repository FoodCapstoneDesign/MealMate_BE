package io.junseok.service

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import io.junseok.config.S3ClientProperties
import io.junseok.dto.S3Response
import io.junseok.error.ErrorCode
import io.junseok.error.MealMateException
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*


@Component
class S3UploadImage(
    private val amazonS3: AmazonS3Client,
    private val s3ClientProperties: S3ClientProperties
) {

    fun saveImage(file: MultipartFile): S3Response {
        try {
            val fileName = UUID.randomUUID().toString()

            val metadata = ObjectMetadata()
            metadata.contentType = file.contentType
            metadata.contentLength = file.size

            amazonS3.putObject(s3ClientProperties.bucket, fileName, file.inputStream, metadata)
            val imageUrl = amazonS3.getUrl(s3ClientProperties.bucket, fileName).toString()
            return S3Response(
                imageUrl=imageUrl,
                fileName=fileName
            )
        } catch (e: IOException) {
            throw MealMateException(ErrorCode.EXIST_EMAIL)
        }
    }
}
