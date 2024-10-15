dependencies {
    implementation(project(":mealmate-domain"))
    implementation(project(":mealmate-storage"))
    implementation(project(":mealmate-common"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    //security
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springdoc:springdoc-openapi-ui:1.7.0")
}
tasks {
    bootJar {
        enabled = true
    }

    jar {
        enabled = false
    }
}

jib {
    from {
        image = "openjdk:17"
    }
    to {
        image = "${System.getenv("DOCKER_USERNAME")}/mealmate-0.0.1-api-snapshot"
        auth {
            username = System.getenv("DOCKER_USERNAME") ?: ""
            password = System.getenv("DOCKER_TOKEN") ?: ""
        }
    }
    container {
        ports = listOf("8080")
        mainClass = "io.junseok.mealmateapi.MealmateApiApplication"
    }
}