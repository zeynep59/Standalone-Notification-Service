package com.example.sms

import com.example.sms.config.AwsConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(AwsConfiguration::class) //figensoft configuration will be added
@SpringBootApplication
class SmsApplication

fun main(args: Array<String>) {
    runApplication<SmsApplication>(*args)
}
