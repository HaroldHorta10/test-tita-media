package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.port.IBankService;
import com.test.titamedia.titamediatest.client.constat.ClientApiConstants;
import com.test.titamedia.titamediatest.persistence.entities.BankEntity;
import com.test.titamedia.titamediatest.persistence.repositories.BankJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BankServiceImpl implements IBankService {
    private final BankJpaRepository repository;

    public BankServiceImpl(BankJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bank consult(Integer id) throws DataNotFoundPersistenceException {
        return toBank(Optional.ofNullable(repository.findAllById(id))
                .orElseThrow(() -> new DataNotFoundPersistenceException(HttpStatus.NOT_FOUND, ClientApiConstants.BANK_NO_FOUND)));
    }

    @Override
    public Bank save(Bank bank) {
        return toBank(repository.save(toBankEntity(bank)));
    }

    @Override
    public List<Bank> findAll() {
        return repository.findAll().stream().map(this::toBank).collect(Collectors.toList());
    }

    @Override
    public boolean existsAllByCode(String code) throws ServiceGeneralException {
        if (repository.existsAllByCode(code)) {
            throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, ClientApiConstants.BANK_EXIST);
        }
        return false;
    }

    private BankEntity toBankEntity(Bank bank) {
        return BankEntity.builder()
                .code(bank.getCode())
                .name(bank.getName())
                .build();
    }

    private Bank toBank(BankEntity bankEntity) {
        return Bank.builder()
                .code(bankEntity.getCode())
                .name(bankEntity.getName())
                .build();
    }
}
