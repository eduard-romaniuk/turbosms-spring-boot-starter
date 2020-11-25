package org.eduard.romaniuk.turbosms.service.impl;

enum TurboSmsEndpoint {
    MESSAGE_SEND("/message/send.json");
    private final String value;

    TurboSmsEndpoint(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }
}
