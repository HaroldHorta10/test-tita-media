package com.test.titamedia.titamediatest.credit.port;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.domain.CreditRequest;
import com.test.titamedia.titamediatest.credit.domain.CreditResponse;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface ICreditService {
    CreditResponse save(CreditRequest creditRequest);
    Credit consult(String credit) throws DataNotFoundPersistenceException;
    List<Credit> findAll();
}
