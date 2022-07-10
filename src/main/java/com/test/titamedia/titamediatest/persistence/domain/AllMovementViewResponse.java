package com.test.titamedia.titamediatest.persistence.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMovementViewResponse {

    private BigDecimal balance;
    private Integer fee;
    private String documentNumber;
    private String code;

}
