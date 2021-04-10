package io.github.eduardromanyuk.turbosms.service.impl;

enum TsEndpoint {
    MESSAGE_SEND("/message/send.json"),
    MESSAGE_STATUS("/message/status.json"),
    USER_BALANCE("/user/balance.json"),
    FILE_ADD("/file/add.json"),
    FILE_DETAILS("/file/details.json");
    private final String value;

    TsEndpoint(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }
}
