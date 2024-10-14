package io.junseok.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan
class S3Config(private val s3ClientProperties: S3ClientProperties) {

    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val credentials = BasicAWSCredentials(s3ClientProperties.accessKey, s3ClientProperties.secretKey)

        return AmazonS3ClientBuilder
            .standard()
            .withRegion(s3ClientProperties.region)
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .build() as AmazonS3Client
    }
}