package org.eduard.romaniuk.turbosms.service.impl;

import lombok.RequiredArgsConstructor;
import org.eduard.romaniuk.turbosms.service.PingService;

@RequiredArgsConstructor
public class PingServiceImpl implements PingService {
    private final String token;

    public String ping() {
        return token;
    }
}
