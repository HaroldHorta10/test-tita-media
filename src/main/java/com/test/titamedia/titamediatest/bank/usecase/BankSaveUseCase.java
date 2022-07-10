package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;

public interface BankSaveUseCase {
    Bank save(Bank id) throws ServiceGeneralException;
}
