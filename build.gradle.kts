import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.twilio.sdk:twilio:7.34.0")
    implementation("com.google.auth:google-auth-library-oauth2-http:1.16.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation ("com.googlecode.libphonenumber:libphonenumber:8.12.35")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("jakarta.validation:jakarta.validation-api:3.0.0")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation( group= "org.slf4j", name= "slf4j-api", version= "1.7.+")
    implementation(group = "org.springframework.cloud", name = "spring-cloud-aws-messaging", version = "2.2.1.RELEASE")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.amazonaws:aws-java-sdk-sns:1.12.122")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
