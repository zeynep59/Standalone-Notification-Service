package com.example.sms.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


    @Configuration
    @ConfigurationProperties("twilio")
    @ComponentScan("com.example.sms")
    class TwilioConfiguration {
        var accountSid: String? = null
        var authToken: String? = null
        var trialNumber: String? = null
    }
