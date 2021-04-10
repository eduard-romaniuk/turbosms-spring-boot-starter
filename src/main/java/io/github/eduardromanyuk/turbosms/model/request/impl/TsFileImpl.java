package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsFileDataRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsFileUrlRequest;

public class TsFileImpl {
    public static TsFileUrlRequest url(String url) {
        return () -> url;
    }

    public static TsFileDataRequest data(String data) {
        return () -> data;
    }

    private TsFileImpl() {
    }
}
