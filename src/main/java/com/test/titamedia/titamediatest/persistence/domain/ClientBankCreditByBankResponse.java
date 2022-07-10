package com.test.titamedia.titamediatest.persistence.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientBankCreditByBankResponse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String bankCode;
    private String bankName;
    private String documentNumber;
    private String creditCode;

}
