package com.test.titamedia.titamediatest.client.usecase;

import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

import java.util.List;

public interface ClientConsultUseCase {
    Client consult(String documentNumber) throws DataNotFoundPersistenceException;
    List<Client> consult();
}
