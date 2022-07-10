package com.test.titamedia.titamediatest.movement.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMovementResponse {

    private BigDecimal balancePay;
    private Integer feeToPay;
    private BigDecimal moneyToPay;
    private String code;

}
