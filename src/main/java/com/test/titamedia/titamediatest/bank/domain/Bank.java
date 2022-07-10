package com.test.titamedia.titamediatest.bank.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bank {

    @Schema(description = "Code bank", example = "001")
    private String code;
    @Schema(description = "name bank", example = "BankOpita")
    private String name;

}
