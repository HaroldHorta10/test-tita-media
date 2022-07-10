package com.test.titamedia.titamediatest.movement.usecase;

import com.test.titamedia.titamediatest.movement.domain.PayRequest;
import com.test.titamedia.titamediatest.movement.domain.MovementResponse;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

public interface MovementSaveUseCase {
    MovementResponse save(PayRequest id) throws DataNotFoundPersistenceException, ServiceGeneralException;
}
