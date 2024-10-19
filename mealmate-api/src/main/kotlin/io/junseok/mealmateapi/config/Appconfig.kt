package io.junseok.mealmateapi.config

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class AppConfig(private val applicationContext: ApplicationContext) {

    @PostConstruct
    fun init() {
        AdminReaderProvider.initializeApplicationContext(applicationContext)
    }
}