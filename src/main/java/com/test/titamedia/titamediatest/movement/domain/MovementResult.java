package com.test.titamedia.titamediatest.movement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class MovementResult {

    @JsonProperty("code")
    private String code;

    @JsonProperty("text")
    private String text;
}
