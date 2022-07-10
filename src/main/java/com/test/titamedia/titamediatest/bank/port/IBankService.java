package com.test.titamedia.titamediatest.bank.port;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;

import java.util.List;

public interface IBankService {
    Bank consult(Integer id) throws DataNotFoundPersistenceException;
    Bank save(Bank bank);
    List<Bank> findAll();

    boolean existsAllByCode(String code) throws ServiceGeneralException;

}
