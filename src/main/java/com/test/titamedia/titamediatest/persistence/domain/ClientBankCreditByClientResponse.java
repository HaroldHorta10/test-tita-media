package com.test.titamedia.titamediatest.persistence.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientBankCreditByClientResponse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String code;
    private String name;
    private String documentNumber;

}
