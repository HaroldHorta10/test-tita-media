package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface BankConsultUseCase {
    Bank consult(Integer id) throws DataNotFoundPersistenceException;
    List<Bank> findAll();

}
