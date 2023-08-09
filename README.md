Sms For Standalone Notification Service
===

The Standalone SMS Notification Service is a robust Spring Boot solution that seamlessly integrates multiple SMS service providers, including Twilio, Figensoft, and AWS SNS.


## Requirements
Before running the project, please ensure that you provide the necessary environment variables for proper configuration. The YAML file (`application.yml`) contains placeholders within `${}` for sensitive information such as access credentials, API tokens, and authentication details. When launching the project, make sure to replace these placeholders with the actual values of your credentials in your local environment or deployment platform. These environment variables ensure secure and personalized configuration for services like AWS, Twilio, and Figensoft, allowing the Standalone SMS Notification Service to function seamlessly and securely.

``` YAML
cloud:
    aws:
        credentials:
            accessKeyId: ${ACCESS_KEY_ID}
            secretKey: ${SECRET_KEY}
        region: us-east-1

twilio:
    account_sid: ${ACCOUNT_SID}
    auth_token: ${AUTH_TOKEN}
    from_number: ${FROM_NUMBER}

figensoft:
    url: https://www.postaguvercini.com/api_http
    singleSMS: /sendsms.asp
    username: ${FIGEN SOFT_USERNAME}
    password: ${FIGEN SOFT_PASSWORD}
    timeout: 5s
```


## Running the application
You can directly run your application your local machine. There’s no need to install a Servlet container. In a terminal window execute the following command from the root level of the project:



#### Mac OS X/ Unix

<code>./gradlew bootRun  </code>


#### Windows

<code>gradlew.bat bootRun </code>

## Using the Service
To leverage the capabilities of the Service, you can make requests to the designated endpoint using your preferred HTTP client. Follow the steps below to send SMS notifications:

#### Endpoint:
```
http://localhost:8080/sms/send
```
#### Request Body:

```JSON
{
    "phoneNumbers": ["+90xxxxxxxxxx", "+90xxxxxxxxx"],
    "message": "You can write your message here!",
    "channel": "AWS"
}

```
Select one of the desired SMS providers (<span style="color:orange">Twilio</span>, <span style="color:orange">AWS</span>, or <span style="color:orange">Figensoft</span>) by specifying the corresponding <span style="color:green">channel</span> in the request.





