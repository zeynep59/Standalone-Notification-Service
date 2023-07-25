package com.example.sms.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClient
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean

@ConfigurationProperties(prefix = "cloud.aws.credentials")
class AwsConfiguration( var  accessKeyId: String,
                        var secretKey: String) {



    @Bean
    fun amazonSNS (): AmazonSNS {
        val basicAwsCredentials =  BasicAWSCredentials(accessKeyId, secretKey)
        return AmazonSNSClient.builder().withRegion(Regions.US_EAST_1).withCredentials(AWSStaticCredentialsProvider(basicAwsCredentials)).build()
    }
}