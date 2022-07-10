package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_bank_credit", catalog = "")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientBankCreditEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String documentNumber;
    private int idBank;
    private String idCredit;

}
