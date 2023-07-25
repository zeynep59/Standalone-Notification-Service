package com.example.sms.controller

import com.example.sms.model.ChannelType
import com.example.sms.model.SmsModel
import com.example.sms.service.AwsService
import com.example.sms.service.TwilioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/sms")
class SmsController {


    @Autowired
    lateinit var awsService: AwsService
    lateinit var twilioService: TwilioService


    @PostMapping("/send")
    fun sendSms(@RequestBody smsModel: SmsModel): Any {
        return when (smsModel.channel){
            ChannelType.AWS -> {
                awsService.sendSms(smsModel)
            }

            ChannelType.Twilio -> {
                twilioService.sendSms(smsModel)
            }
            else ->{
                println("Invalid Channel")
            }

        }
    }

}