package com.test.titamedia.titamediatest.movement.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PayRequest {
    @Schema(description = "balance total credit, if creditFeeToPay is 0, total balance credit", example = "22000")
    private BigDecimal balance;
    @Schema(description = "credit id", example = "1")
    private String creditId;
    @Schema(description = "number of installments to pay if value is 0, total payment", example = "1")
    private Integer creditFeeToPay;
}
