package io.junseok.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("cloud.aws")
data class S3ClientProperties(
    val accessKey: String,
    val secretKey: String,
    val region: String,
    val bucket: String,
)