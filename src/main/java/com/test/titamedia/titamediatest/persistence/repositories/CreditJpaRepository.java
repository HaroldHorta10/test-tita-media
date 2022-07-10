package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditJpaRepository extends JpaRepository<CreditEntity, String> {

    CreditEntity findAllByCode(String credit);
}
