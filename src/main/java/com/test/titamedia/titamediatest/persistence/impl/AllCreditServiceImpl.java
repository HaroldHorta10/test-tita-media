package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.allcredit.domain.AllCredit;
import com.test.titamedia.titamediatest.allcredit.port.IAllCreditService;
import com.test.titamedia.titamediatest.persistence.entities.AllCreditViewEntity;
import com.test.titamedia.titamediatest.persistence.repositories.AllCreditViewJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AllCreditServiceImpl implements IAllCreditService {
    private final AllCreditViewJpaRepository repository;

    public AllCreditServiceImpl(AllCreditViewJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AllCredit> consult(String document) throws DataNotFoundPersistenceException {
        return repository.findAllByDocumentNumber(document).stream().map(this::toClient).collect(Collectors.toList());
    }


    private AllCredit toClient(AllCreditViewEntity entity) {
        return AllCredit.builder()
                .documentNumber(entity.getDocumentNumber())
                .creditCode(entity.getCreditCode())
                .nameBank(entity.getNameBank())
                .build();
    }
}
