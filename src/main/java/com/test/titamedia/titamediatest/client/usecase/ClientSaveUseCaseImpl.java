package com.test.titamedia.titamediatest.client.usecase;

import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.client.port.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientSaveUseCaseImpl implements BankSaveUseCase {
    private final IClientService IClientService;

    public ClientSaveUseCaseImpl(IClientService IClientService) {
        this.IClientService = IClientService;
    }

    @Override
    public Client save(Client client) {
        return IClientService.save(client);
    }
}
