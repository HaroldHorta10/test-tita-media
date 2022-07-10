package com.test.titamedia.titamediatest.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String documentNumber;
    private String documentType;
    private String name;


}
