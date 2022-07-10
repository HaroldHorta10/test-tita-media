package com.test.titamedia.titamediatest.credit.usecase;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.port.ICreditService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CreditConsultUseCaseImpl implements CreditConsultUseCase {
    private final ICreditService clientService;

    public CreditConsultUseCaseImpl(ICreditService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Credit consult(String credit) throws DataNotFoundPersistenceException {
        return clientService.consult(credit);
    }

    @Override
    public List<Credit> findAll() {
        return clientService.findAll();
    }

}
