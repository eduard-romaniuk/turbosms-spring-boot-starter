package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsFileDetailsRequest;

public class TsFileDetailsRequestBuilder {
    public static TsFileDetailsRequest id(long id) {
        return () -> id;
    }

    private TsFileDetailsRequestBuilder() {
    }
}
