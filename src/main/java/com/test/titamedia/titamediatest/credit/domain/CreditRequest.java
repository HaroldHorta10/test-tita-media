package com.test.titamedia.titamediatest.credit.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreditRequest {

    @Schema(description = "balance total credit", example = "100000")
    private BigDecimal balanceTotal;
    @Schema(description = "credit fee", example = "5")
    private Integer creditFee;
    @Schema(description = "id bank", example = "1")
    private Integer idBank;
    @Schema(description = "document", example = "1234")
    private String documentNumber;
    @Schema(description = "value financial interest", example = "10")
    private Double financialInterest;

}
