package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankJpaRepository extends JpaRepository<BankEntity, Integer> {
    BankEntity findAllById(int id);
    boolean existsAllByCode(String code);
}
