package com.test.titamedia.titamediatest.allcredit.port;

import com.test.titamedia.titamediatest.allcredit.domain.AllCredit;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface IAllCreditService {
    List<AllCredit> consult(String document) throws DataNotFoundPersistenceException;
}
