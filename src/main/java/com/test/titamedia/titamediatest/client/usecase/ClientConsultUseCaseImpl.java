package com.test.titamedia.titamediatest.client.usecase;

import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.client.port.IClientService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientConsultUseCaseImpl implements ClientConsultUseCase {
    private final IClientService clientService;

    public ClientConsultUseCaseImpl(IClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Client consult(String documentNumber) throws DataNotFoundPersistenceException {
        return clientService.consult(documentNumber);
    }

    @Override
    public List<Client> consult() {
        return clientService.findAll();
    }

}
