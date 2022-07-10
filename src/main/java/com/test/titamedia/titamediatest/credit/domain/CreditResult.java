package com.test.titamedia.titamediatest.credit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class CreditResult {

    @JsonProperty("code")
    private String code;

    @JsonProperty("text")
    private String text;
}
