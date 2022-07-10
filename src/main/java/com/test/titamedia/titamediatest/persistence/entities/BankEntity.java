package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String code;
    private String name;

}
