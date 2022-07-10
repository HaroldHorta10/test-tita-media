package com.test.titamedia.titamediatest.credit.usecase;

import com.test.titamedia.titamediatest.credit.domain.CreditRequest;
import com.test.titamedia.titamediatest.credit.domain.CreditResponse;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

public interface CreditSaveUseCase {
    CreditResponse save(CreditRequest id) throws DataNotFoundPersistenceException, ServiceGeneralException;
}
