package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.entities.MovementEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovementJpaRepository extends PagingAndSortingRepository<MovementEntity, Long> {
    List<MovementEntity> findAllByCreditId(String code);
}
