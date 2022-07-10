package com.test.titamedia.titamediatest.movement.usecase;

import com.test.titamedia.titamediatest.movement.domain.AllMovementResponse;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;

public interface MovementConsultUseCase {
    AllMovementResponse consultMovement(String code) throws ServiceGeneralException, DataNotFoundPersistenceException;


}
