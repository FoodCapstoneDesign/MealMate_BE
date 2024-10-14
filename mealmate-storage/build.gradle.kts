allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    runtimeOnly("com.mysql:mysql-connector-j")
    compileOnly(project(":mealmate-domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}