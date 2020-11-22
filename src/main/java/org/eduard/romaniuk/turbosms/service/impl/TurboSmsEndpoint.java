package org.eduard.romaniuk.turbosms.service.impl;

enum TurboSmsEndpoint {
    MESSAGE_SEND("/message/send.json");
    private static final String BASE_URL = "https://api.turbosms.ua";
    private String value;

    TurboSmsEndpoint(String value) {
        this.value = BASE_URL + value;
    }

    String value() {
        return value;
    }
}
