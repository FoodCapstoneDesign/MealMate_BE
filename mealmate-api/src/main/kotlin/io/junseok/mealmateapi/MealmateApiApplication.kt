package io.junseok.mealmateapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MealmateApiApplication

fun main(args: Array<String>) {
    runApplication<MealmateApiApplication>(*args)
}
