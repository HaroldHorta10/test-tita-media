package com.test.titamedia.titamediatest.credit.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Credit {

    private String code;
    private BigDecimal balanceTotal;
    private Integer creditFee;
    private BigDecimal valueFee;

}
