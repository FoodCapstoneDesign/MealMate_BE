package io.junseok.service

import com.amazonaws.services.s3.AmazonS3Client
import io.junseok.config.S3ClientProperties
import org.springframework.stereotype.Component

@Component
class S3DeleteImage(
    private val amazonS3: AmazonS3Client,
    private val s3ClientProperties: S3ClientProperties
) {
    fun deleteImage(fileName: String?) {
        amazonS3.deleteObject(s3ClientProperties.bucket, fileName)
    }
}
