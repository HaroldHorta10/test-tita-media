package com.test.titamedia.titamediatest.clientbankcredit.usecase;

import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByBankCredit;
import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByClientCredit;
import com.test.titamedia.titamediatest.clientbankcredit.port.IClientBankCreditService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientBankCreditConsultUseCaseImpl implements ClientBankCreditConsultUseCase {
    private final IClientBankCreditService service;

    public ClientBankCreditConsultUseCaseImpl(IClientBankCreditService service) {
        this.service = service;
    }


    @Override
    public List<ClientBankCreditByClientCredit> consult(String document) throws DataNotFoundPersistenceException {
        return service.consult(document);
    }

    @Override
    public List<ClientBankCreditByBankCredit> consultBank(String nameOrCode) {
        return service.consultBank(nameOrCode);
    }

    @Override
    public List<ClientBankCreditByBankCredit> consultBankAndClient(String nameOrCode, String document) {
        return service.consultBankAndClient(nameOrCode, document);
    }
}
