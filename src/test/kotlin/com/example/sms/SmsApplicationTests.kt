package com.example.sms

import com.example.sms.model.ChannelType
import com.example.sms.model.SmsModel
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) class SmsApplicationTests(
    @Autowired val webClient: WebTestClient

) {

    @Test
    fun `send sms AWS`() {
        webClient.post()
            .uri("/sms/send")
            .bodyValue(
                SmsModel(
                    phoneNumber = "+905464932088",
                    message = "success",
                    channel = ChannelType.AWS

                )
            ).exchange()
            .expectStatus().isOk
    }


    @Test
    fun `send sms Twilio`() {
        webClient.post()
            .uri("/sms/send")
            .bodyValue(
                SmsModel(
                    phoneNumber = "+905464932088",
                    message = "success",
                    channel = ChannelType.Twilio

                )
            ).exchange()
            .expectStatus().isOk
    }

}

