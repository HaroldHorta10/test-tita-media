package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.client.constat.ClientApiConstants;
import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.client.port.IClientService;
import com.test.titamedia.titamediatest.persistence.entities.ClientEntity;
import com.test.titamedia.titamediatest.persistence.repositories.ClientJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientServiceImpl implements IClientService {
    private final ClientJpaRepository repository;

    public ClientServiceImpl(ClientJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client consult(String id) throws DataNotFoundPersistenceException {
        return toClient(Optional.ofNullable(repository.findAllByDocumentNumber(id))
                .orElseThrow(() -> new DataNotFoundPersistenceException(HttpStatus.NOT_FOUND, ClientApiConstants.CLIENT_NO_FOUND)));
    }

    @Override
    public Client save(Client client) {
        return toClient(repository.save(toClientEntity(client)));
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll().stream().map(this::toClient).collect(Collectors.toList());
    }

    private ClientEntity toClientEntity(Client client) {
        return ClientEntity.builder()
                .documentNumber(client.getDocumentNumber())
                .documentType(client.getDocumentType())
                .name(client.getName())
                .build();
    }

    private Client toClient(ClientEntity clientEntity) {
        return Client.builder()
                .documentNumber(clientEntity.getDocumentNumber())
                .documentType(clientEntity.getDocumentType())
                .name(clientEntity.getName())
                .build();
    }
}
