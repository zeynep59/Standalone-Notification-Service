package com.example.sms.service

import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.model.MessageAttributeValue
import com.amazonaws.services.sns.model.PublishRequest
import com.amazonaws.services.sns.model.PublishResult
import com.example.sms.model.SmsModel
import org.apache.kafka.common.requests.FetchMetadata.log
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AwsService(private var snsClient: AmazonSNS
) {

    private var AWS_SNS_SMS_TYPE: String = "AWS.SNS.SMS.SMSType"
    private var AWS_SNS_SMS_TYPE_VALUE: String = "Transactional"
    private var AWS_SNS_DATA_TYPE: String  = "String"


    fun sendSms(smsModel: SmsModel){
        try{
            var requestTimeout: Int = 3000
            val smsAttributes = HashMap<String, MessageAttributeValue>().apply {
                put(AWS_SNS_SMS_TYPE, MessageAttributeValue()
                    .withStringValue(AWS_SNS_SMS_TYPE_VALUE)
                    .withDataType(AWS_SNS_DATA_TYPE)
                )
            }

            var request : PublishResult = snsClient.publish((PublishRequest()
                .withMessage(smsModel.message)
                .withPhoneNumber(smsModel.phoneNumber)
                .withMessageAttributes(smsAttributes)
                .withSdkRequestTimeout(requestTimeout)))

            log.debug(request.toString())


        }catch (e: RuntimeException  ){
            val log = LoggerFactory.getLogger("AwsSnsClient")
            log.error("Error occurred sending SMS to $smsModel.phoneNumber", e)

        }
    }
}