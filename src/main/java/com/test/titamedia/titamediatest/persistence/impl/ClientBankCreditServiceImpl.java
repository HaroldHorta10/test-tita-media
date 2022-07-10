package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByBankCredit;
import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByClientCredit;
import com.test.titamedia.titamediatest.clientbankcredit.port.IClientBankCreditService;
import com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByBankResponse;
import com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByClientResponse;
import com.test.titamedia.titamediatest.persistence.repositories.ClientBankCreditJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientBankCreditServiceImpl implements IClientBankCreditService {
    private final ClientBankCreditJpaRepository repository;

    public ClientBankCreditServiceImpl(ClientBankCreditJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientBankCreditByClientCredit> consult(String document) throws DataNotFoundPersistenceException {
        return repository.findAllByDocumentNumber(document).stream().map(this::toClient).collect(Collectors.toList());
    }

    @Override
    public List<ClientBankCreditByBankCredit> consultBank(String nameOrCode) {
        return repository.findAllByBank(nameOrCode).stream().map(this::toClientByBank).collect(Collectors.toList());
    }

    @Override
    public List<ClientBankCreditByBankCredit> consultBankAndClient(String nameOrCode, String document) {
        return repository.findAllByBankAndClient(nameOrCode, document).stream().map(this::toClientByBank).collect(Collectors.toList());
    }


    private ClientBankCreditByClientCredit toClient(ClientBankCreditByClientResponse entity) {
        return ClientBankCreditByClientCredit.builder()
                .documentNumber(entity.getDocumentNumber())
                .nameBank(entity.getName())
                .bankCode(entity.getCode())
                .build();
    }

    private ClientBankCreditByBankCredit toClientByBank(ClientBankCreditByBankResponse entity) {
        return ClientBankCreditByBankCredit.builder()
                .documentNumber(entity.getDocumentNumber())
                .nameBank(entity.getBankName())
                .bankCode(entity.getBankCode())
                .creditCode(entity.getCreditCode())
                .build();
    }
}
