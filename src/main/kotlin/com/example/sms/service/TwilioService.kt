package com.example.sms.service

import com.example.sms.config.TwilioConfiguration
import com.example.sms.model.SmsModel
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.twilio.rest.api.v2010.account.Message
import com.twilio.rest.api.v2010.account.MessageCreator
import com.twilio.type.PhoneNumber
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TwilioService @Autowired constructor(private val twilioConfiguration: TwilioConfiguration) {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(TwilioService::class.java)
    }

    private fun isPhoneNumberValid(phoneNumber: String): Boolean {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        try {
            val numberProto: Phonenumber.PhoneNumber = phoneNumberUtil.parse(phoneNumber, null)
            return phoneNumberUtil.isValidNumber(numberProto)
        } catch (e: Exception) {
            return false
        }
    }

    fun sendSms(smsModel: SmsModel) {
        val phoneNumber = smsModel.phoneNumber
        if (isPhoneNumberValid(phoneNumber)) {
            val to = PhoneNumber(phoneNumber)
            val from = PhoneNumber(twilioConfiguration.trialNumber)
            val message = smsModel.message
            val creator: MessageCreator = Message.creator(to, from, message)
            creator.create()
            LOGGER.info("Send sms {}", smsModel)
        } else {
            throw IllegalArgumentException("Phone number [$phoneNumber] is not a valid number")
        }
    }
}
