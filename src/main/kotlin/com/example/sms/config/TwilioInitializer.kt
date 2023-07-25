package com.example.sms.config

import com.twilio.Twilio
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class TwilioInitializer @Autowired constructor(twilioConfiguration: TwilioConfiguration) {
    private val twilioConfiguration: TwilioConfiguration

    init {
        this.twilioConfiguration = twilioConfiguration
        Twilio.init(
            twilioConfiguration.accountSid,
            twilioConfiguration.authToken
        )
        LOGGER.info("Twilio initialized .. with account sid {}", twilioConfiguration.accountSid)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(TwilioInitializer::class.java)
    }
}