package io.github.eduardromanyuk.turbosms.service.impl;

enum TsEndpoint {
    MESSAGE_SEND("/message/send.json");
    private final String value;

    TsEndpoint(String value) {
        this.value = value;
    }

    String value() {
        return value;
    }
}