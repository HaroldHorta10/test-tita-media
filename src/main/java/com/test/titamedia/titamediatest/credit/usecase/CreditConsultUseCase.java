package com.test.titamedia.titamediatest.credit.usecase;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface CreditConsultUseCase {
    Credit consult(String credit) throws DataNotFoundPersistenceException;
    List<Credit> findAll();


}
