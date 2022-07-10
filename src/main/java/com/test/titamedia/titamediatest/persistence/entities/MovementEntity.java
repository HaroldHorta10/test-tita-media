package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private BigDecimal balance;
    private String creditId;
    private Integer creditFee;
}
