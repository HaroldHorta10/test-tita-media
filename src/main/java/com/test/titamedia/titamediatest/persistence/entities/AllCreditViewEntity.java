package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "all_credit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllCreditViewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String nameBank;
    private String codeBank;
    private String creditCode;
    private String documentNumber;

}
