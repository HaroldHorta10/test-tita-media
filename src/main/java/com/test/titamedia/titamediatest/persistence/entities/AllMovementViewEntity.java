package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "all_movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMovementViewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private BigDecimal balance;
    private Integer fee;
    private String documentNumber;
    private String code;

}
