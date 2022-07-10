package com.test.titamedia.titamediatest.clientbankcredit.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientBankCreditByClientCredit {

    @Schema(description = "Code credit", example = "001")
    private String bankCode;
    @Schema(description = "name bank", example = "BankOpita")
    private String nameBank;
    private String documentNumber;

}
