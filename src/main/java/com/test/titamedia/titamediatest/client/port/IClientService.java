package com.test.titamedia.titamediatest.client.port;

import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface IClientService {
    Client consult(String id) throws DataNotFoundPersistenceException;
    Client save(Client client);
    List<Client> findAll();
}
