package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.movement.constat.MovementApiConstants;
import com.test.titamedia.titamediatest.movement.domain.PayRequest;
import com.test.titamedia.titamediatest.movement.domain.MovementResponse;
import com.test.titamedia.titamediatest.movement.domain.MovementResult;
import com.test.titamedia.titamediatest.movement.port.IPayService;
import com.test.titamedia.titamediatest.persistence.domain.AllMovementViewResponse;
import com.test.titamedia.titamediatest.persistence.entities.AllMovementViewEntity;
import com.test.titamedia.titamediatest.persistence.entities.MovementEntity;
import com.test.titamedia.titamediatest.persistence.repositories.AllMovementViewJpaRepository;
import com.test.titamedia.titamediatest.persistence.repositories.MovementJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PayServiceImpl implements IPayService {
    private final MovementJpaRepository repository;
    private final AllMovementViewJpaRepository movementViewJpaRepository;

    public PayServiceImpl(MovementJpaRepository repository, AllMovementViewJpaRepository movementViewJpaRepository) {
        this.repository = repository;
        this.movementViewJpaRepository = movementViewJpaRepository;
    }

    @Override
    public MovementResponse save(PayRequest payRequest) throws ServiceGeneralException {
        repository.save(toMovementEntity(payRequest));
        return toMovementResponse();
    }

    @Override
    public List<AllMovementViewEntity> consult(String code) throws ServiceGeneralException {
        return movementViewJpaRepository.findAllByCode(code);
    }

    @Override
    public List<AllMovementViewResponse> consultByCodeCredit(String code) {
        return movementViewJpaRepository.findAllByCode(code).stream().map(this::toMovementResponse).collect(Collectors.toList());
    }

    private MovementEntity toMovementEntity(PayRequest payRequest) {
        return MovementEntity.builder()
                .creditId(payRequest.getCreditId())
                .balance(payRequest.getBalance())
                .creditFee(payRequest.getCreditFeeToPay())
                .build();
    }

    private AllMovementViewResponse toMovementResponse(AllMovementViewEntity entity) {
        return AllMovementViewResponse.builder()
                .balance(entity.getBalance())
                .fee(entity.getFee())
                .documentNumber(entity.getDocumentNumber())
                .code(entity.getCode())
                .build();
    }

    private MovementResponse toMovementResponse() {
        return MovementResponse.builder()
                .result(MovementResult.builder()
                        .code(String.valueOf(HttpStatus.CREATED.value()))
                        .text(MovementApiConstants.SUCCESS_TEXT)
                        .build())
                .build();
    }
}
