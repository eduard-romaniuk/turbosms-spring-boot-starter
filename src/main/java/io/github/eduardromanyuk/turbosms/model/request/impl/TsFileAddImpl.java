package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsFileAddDataRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsFileAddUrlRequest;

public class TsFileAddImpl {
    public static TsFileAddUrlRequest url(String url) {
        return () -> url;
    }

    public static TsFileAddDataRequest data(String data) {
        return () -> data;
    }

    private TsFileAddImpl() {
    }
}
