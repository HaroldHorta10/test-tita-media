package com.test.titamedia.titamediatest.movement.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MovementResponse {

    private MovementResult result;
    private BigDecimal balancePending;
    private String creditFee;

    public static MovementResponse buildWithCodeAndText(String code, String text) {
        return MovementResponse.builder()
                .result(
                        MovementResult.builder()
                                .code(code)
                                .text(text)
                                .build()
                )
                .build();
    }

}
