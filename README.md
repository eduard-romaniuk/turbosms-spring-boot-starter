# TurboSMS SpringBoot starter ![maven](https://img.shields.io/maven-central/v/io.github.eduard-romanyuk/turbosms-spring-boot-starter.svg?label=maven)

## Description
This starter provides infrastructure for using [TurboSMS](https://turbosms.ua/) sms/viber provider. For communication used [HTTP API](https://turbosms.ua/api.html).

## Versions
| Version | Branch | Documentation |
| ------- | ------------------ | --- |
| 2.0.0  | [main](https://github.com/eduard-romanyuk/turbosms-spring-boot-starter/tree/main) | readme.md |
| 1.2.0  | [v1](https://github.com/eduard-romanyuk/turbosms-spring-boot-starter/tree/v1) | [wiki](https://github.com/eduard-romanyuk/turbosms-spring-boot-starter/wiki/v1.2.0-documentation) |

## Configure starter
For enabling starter you should provide `turbosms.token` property. After that autowire `TsApiService` anywhere you need access to **TurboSMS** API's.

## /message/send.json
### Description
Send a message.
Method support three types of messages. Sms and Viber types strictly send messages to chosen platform.
When hybrid type trying to send message to Viber and in case of failure send this message as SMS.

### Example
```java
@Component
public class MessageSendExample {
  private final TsApiService service;
  private static final String SMS_SENDER = "your sms sender";
  private static final String VIBER_SENDER = "your viber sender";

  public MessageSendExample(TsApiService service) {
    this.service = service;
  }

  public void smsBuilder() {
    TsMessageSendSmsRequest sms = TsMessageSendSmsRequestBuilder.from(SMS_SENDER)
        .recipient("+380991112233")
        .text("Hello, TurboSMS")
        .build();
    printSendStatus(service.messageSend(sms));
  }

  public void viberBuilder() {
    TsMessageSendViberRequest viber = TsMessageSendViberRequestBuilder.from(VIBER_SENDER)
        .countClicks()
        .recipient("+380991112233")
        .text("Hello, TurboSMS")
        .build();
    printSendStatus(service.messageSend(viber));
  }

  public void hybridBuilder() {
    TsMessageSendHybridRequest hybrid = TsMessageSendHybridRequestBuilder.from(SMS_SENDER, VIBER_SENDER)
        .recipient("+380991112233")
        .viberSettings()
        .text("Text for Viber")
        .countClicks()
        .build()
        .smsSettings()
        .text("Text for SMS")
        .startTime(LocalDateTime.now())
        .build()
        .build();
    printSendStatus(service.messageSend(hybrid));
  }

  public void hybridBuilderWithCommonText() {
    TsMessageSendHybridRequest hybrid = TsMessageSendHybridRequestBuilder.from(SMS_SENDER, VIBER_SENDER)
        .recipient("+380991112233")
        .text("Common text")
        .viberSettings()
        .countClicks()
        .build()
        .smsSettings()
        .startTime(LocalDateTime.now())
        .build()
        .build();
    printSendStatus(service.messageSend(hybrid));
  }

  private void printSendStatus(ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> response) {
    if (response.hasBody()) {
      TsResponseWrapper<List<TsMessageSendResponse>> body = response.getBody();
      System.out.println("Response status: " + body.getResponseStatus());
      if (body.getResponseResult() != null) {
        for(TsMessageSendResponse message : body.getResponseResult()) {
          System.out.println(message.getMessageId() + ": " + message.getResponseStatus());
        }
      } else {
        System.out.println("Empty TurboSMS response result");
      }
    } else {
      System.out.println("Empty http response body");
    }
  }
}
```

## /message/status.json
### Description
Returns messages status.

### Example
```java
@Component
public class MessageStatusExample {
  private final TsApiService service;

  public MessageStatusExample(TsApiService service) {
    this.service = service;
  }
  
  public void messageStatus() {
    TsMessageStatusRequest statusRequest;
    statusRequest = TsMessageStatusRequestBuilder.from("id1", "id2");
    statusRequest = TsMessageStatusRequestBuilder.from(Collections.singletonList("id1"));
    statusRequest = new TsMessageStatusRequestBuilder()
        .messages("id1", "id2")
        .addMessage("id3")
        .build();
    ResponseEntity<TsResponseWrapper<List<TsMessageStatusResponse>>> response = 
        service.messageStatus(statusRequest);
    if (response.hasBody()) {
      TsResponseWrapper<List<TsMessageStatusResponse>> body = response.getBody();
      System.out.println("Response status: " + body.getResponseStatus());
      if (body.getResponseResult() != null) {
        for(TsMessageStatusResponse message : body.getResponseResult()) {
          System.out.println(message.getMessageId() + ": " + message.getResponseStatus());
        }
      } else {
        System.out.println("Empty TurboSMS response result");
      }
    } else {
      System.out.println("Empty http response body");
    }
  }
}
```

## /user/balance.json
### Description
Returns account balance

### Example
```java
@Component
public class UserBalanceExample {
  private final TsApiService service;

  public UserBalanceExample(TsApiService service) {
    this.service = service;
  }

  public void userBalance() {
    ResponseEntity<TsResponseWrapper<TsUserBalanceResponse>> response = service.userBalance();
    if (response.hasBody()) {
      TsResponseWrapper<TsUserBalanceResponse> body = response.getBody();
      System.out.println("Response status: " + body.getResponseStatus());
      if (body.getResponseResult() != null) {
        System.out.println("Account balance: " + body.getResponseResult().getBalance());
      } else {
        System.out.println("Empty TurboSMS response result");
      }
    } else {
      System.out.println("Empty http response body");
    }
  }
}
```

## /file/add.json
### Description
Upload file to TurboSMS server. Supported file extensions: doc, docx, rtf, dot, dotx, odt, odf, fodt, txt, pdf, xps, pdax, eps, xls, xlsx, ods, fods, csv, xlsm, xltx, jpg, jpeg, png, gif. The maximum file size is 3 MB.

### Example
```java
@Component
public class FileAddExample {
  private final TsApiService service;

  public FileAddExample(TsApiService service) {
    this.service = service;
  }

  public void fileAdd() {
    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> response;
    response = service.fileAdd(TsFileAddRequestBuilder.url("some url"));
    response = service.fileAdd(TsFileAddRequestBuilder.data("file-data"));
    if (response.hasBody()) {
      TsResponseWrapper<TsFileAddResponse> body = response.getBody();
      System.out.println("Response status: " + body.getResponseStatus());
      if (body.getResponseResult() != null) {
        System.out.println("File id: " + body.getResponseResult().getId());
      } else {
        System.out.println("Empty TurboSMS response result");
      }
    } else {
      System.out.println("Empty http response body");
    }
  }
}
```

## /file/details.json
### Description
Retrieve file details by id

### Example
```java
@Component
public class FileDetailsExample {
  private final TsApiService service;

  public FileDetailsExample(TsApiService service) {
    this.service = service;
  }

  public void fileDetails() {
    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> response =
        service.fileDetails(TsFileDetailsRequestBuilder.id(1));
    if (response.hasBody()) {
      TsResponseWrapper<TsFileAddResponse> body = response.getBody();
      System.out.println("Response status: " + body.getResponseStatus());
      if (body.getResponseResult() != null) {
        System.out.println("File id: " + body.getResponseResult().getId());
        System.out.println("File size (MB): " + body.getResponseResult().getSize());
      } else {
        System.out.println("Empty TurboSMS response result");
      }
    } else {
      System.out.println("Empty http response body");
    }
  }
}
```
