package com.test.titamedia.titamediatest.clientbankcredit.port;

import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByBankCredit;
import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByClientCredit;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface IClientBankCreditService {
    List<ClientBankCreditByClientCredit> consult(String document) throws DataNotFoundPersistenceException;
    List<ClientBankCreditByBankCredit> consultBank(String nameOrCode);
    List<ClientBankCreditByBankCredit> consultBankAndClient(String nameOrCode, String document);
}
