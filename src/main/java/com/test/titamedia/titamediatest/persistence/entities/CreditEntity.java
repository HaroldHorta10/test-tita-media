package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "credit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditEntity {
    @Id
    private String code;
    private BigDecimal balanceTotal;
    private Integer creditFee;
    private BigDecimal valueFee;
    private Double financialInterest;

}
