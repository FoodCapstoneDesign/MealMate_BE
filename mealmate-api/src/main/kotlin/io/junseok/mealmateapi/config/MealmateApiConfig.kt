package io.junseok.mealmateapi.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan
@ComponentScan(basePackages = ["io.junseok"])
class MealmateApiConfig {
}