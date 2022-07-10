package com.test.titamedia.titamediatest.allcredit.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllCredit {

    @Schema(description = "Code credit", example = "001")
    private String creditCode;
    @Schema(description = "name bank", example = "BankOpita")
    private String nameBank;
    private String documentNumber;

}
