package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.AllMovementViewEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AllMovementViewJpaRepository extends PagingAndSortingRepository<AllMovementViewEntity, Integer> {
    List<AllMovementViewEntity> findAllByCode(String code);
}
