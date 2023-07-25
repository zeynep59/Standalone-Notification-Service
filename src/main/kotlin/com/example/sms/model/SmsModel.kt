package com.example.sms.model


data class SmsModel(
    val phoneNumber: String,
    val message: String,
    val channel: ChannelType

){
    val formattedPhoneNumber: String
        get() = phoneNumber.replace("+", "00")

    val maskedPhoneNumber: String
        get() = phoneNumber.replaceRange(phoneNumber.length - 2, phoneNumber.length, "**")

}

enum class ChannelType(s: String) {
    AWS("AWS"),
    Twilio("Twilio"),
    Figensoft("Figensoft")
}
