plugins {
    val springBootVersion = "2.7.13"
    val kotlinVersion = "1.9.24"
    val dependencyVersion = "1.1.4"
    val lombokVersion = "8.1.0"

    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version dependencyVersion
    id("com.google.cloud.tools.jib") version "3.3.1" // JIB 플러그인 여기서 적용

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.lombok") version kotlinVersion
    id("io.freefair.lombok") version lombokVersion
    id("jacoco")
}

project(":mealmate-api") {
    apply(plugin = "com.google.cloud.tools.jib")

    jib {
        from {
            image = "openjdk:17"
        }
        to {
            image = "${project.findProperty("DOCKER_USERNAME")}/mealmate-0.0.1-api-snapshot"
            auth {
                username = project.findProperty("DOCKER_USERNAME")?.toString() ?: ""
                password = project.findProperty("DOCKER_TOKEN")?.toString() ?: ""
            }
        }
        container {
            ports = listOf("8080")
            mainClass = "io.junseok.mealmateapi.MealmateApiApplication"
        }
    }
}

allprojects {
    group = "io.junseok"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }

    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "io.spring.dependency-management")

    kapt {
        keepJavacAnnotationProcessors = true
    }
}

subprojects {
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }
    dependencies {
        if (name != "mealmate-common") {
            implementation(project(":mealmate-common"))
        }
        val mockkVersion = "1.13.8"
        val kotestVersion = "5.8.0"

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        kapt("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.security:spring-security-test")
        testImplementation("io.mockk:mockk:$mockkVersion")
        testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")

        compileOnly("org.projectlombok:lombok")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("io.github.microutils:kotlin-logging:3.0.5")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        implementation("org.springframework.boot:spring-boot-starter-actuator")
    }

    tasks {
        test {
            useJUnitPlatform()
        }
        register("prepareKotlinBuildScriptModel") {}
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "17"
            }
        }
        compileTestKotlin {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
        bootJar {
            enabled = false
        }
        jar {
            enabled = true
        }
    }
}
