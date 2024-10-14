package io.junseok.mealmatestorage.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EntityScan(basePackages = ["io.junseok"])
@EnableJpaRepositories(basePackages = ["io.junseok"])
internal class StorageConfig