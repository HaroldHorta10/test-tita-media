package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, String> {

    ClientEntity findAllByDocumentNumber(String documentNumber);

}
