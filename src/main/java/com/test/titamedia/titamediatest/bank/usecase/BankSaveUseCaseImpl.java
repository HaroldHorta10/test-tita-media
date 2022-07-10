package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.port.IBankService;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankSaveUseCaseImpl implements BankSaveUseCase {
    private final IBankService bankService;

    public BankSaveUseCaseImpl(IBankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public Bank save(Bank bank) throws ServiceGeneralException {
        bankService.existsAllByCode(bank.getCode());
        return bankService.save(bank);
    }
}
