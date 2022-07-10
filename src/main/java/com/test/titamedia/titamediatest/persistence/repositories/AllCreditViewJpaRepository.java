package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.AllCreditViewEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AllCreditViewJpaRepository extends PagingAndSortingRepository<AllCreditViewEntity, Integer> {
    List<AllCreditViewEntity> findAllByDocumentNumber(String document);
}
