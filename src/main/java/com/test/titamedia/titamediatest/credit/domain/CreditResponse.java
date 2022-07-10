package com.test.titamedia.titamediatest.credit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreditResponse {

    @JsonProperty("resultOperation")
    private CreditResult result;


    public static CreditResponse buildWithCodeAndText(String code, String text) {
        return CreditResponse.builder()
                .result(
                        CreditResult.builder()
                                .code(code)
                                .text(text)
                                .build()
                )
                .build();
    }

}
