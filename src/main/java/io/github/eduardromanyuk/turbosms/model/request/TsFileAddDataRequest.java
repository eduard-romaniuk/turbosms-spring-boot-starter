package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface TsFileAddDataRequest {
    @JsonProperty("data")
    String getData();
}
