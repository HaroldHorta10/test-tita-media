package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.port.IBankService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BankConsultUseCaseImpl implements BankConsultUseCase {
    private final IBankService bankService;

    public BankConsultUseCaseImpl(IBankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public Bank consult(Integer id) throws DataNotFoundPersistenceException {
        return bankService.consult(id);
    }

    @Override
    public List<Bank> findAll() {
        return bankService.findAll();
    }

}
