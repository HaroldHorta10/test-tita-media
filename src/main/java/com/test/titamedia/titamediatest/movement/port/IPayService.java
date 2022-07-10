package com.test.titamedia.titamediatest.movement.port;

import com.test.titamedia.titamediatest.movement.domain.PayRequest;
import com.test.titamedia.titamediatest.movement.domain.MovementResponse;
import com.test.titamedia.titamediatest.persistence.domain.AllMovementViewResponse;
import com.test.titamedia.titamediatest.persistence.entities.AllMovementViewEntity;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;

import java.util.List;

public interface IPayService {
    MovementResponse save(PayRequest payRequest) throws ServiceGeneralException;
    List<AllMovementViewEntity> consult(String code) throws ServiceGeneralException;
    List<AllMovementViewResponse> consultByCodeCredit(String code);
}
