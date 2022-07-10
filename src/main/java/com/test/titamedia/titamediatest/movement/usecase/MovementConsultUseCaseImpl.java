package com.test.titamedia.titamediatest.movement.usecase;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.port.ICreditService;
import com.test.titamedia.titamediatest.movement.domain.AllMovementResponse;
import com.test.titamedia.titamediatest.movement.port.IPayService;
import com.test.titamedia.titamediatest.persistence.domain.AllMovementViewResponse;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class MovementConsultUseCaseImpl implements MovementConsultUseCase {
    private final IPayService service;
    private final ICreditService creditService;

    public MovementConsultUseCaseImpl(IPayService clientService, ICreditService creditService) {
        this.service = clientService;
        this.creditService = creditService;
    }


    @Override
    public AllMovementResponse consultMovement(String code) throws DataNotFoundPersistenceException {
        Credit credit = creditService.consult(code);
        List<AllMovementViewResponse> response = service.consultByCodeCredit(code);
        BigDecimal pay = response
                .stream()
                .map(AllMovementViewResponse::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return AllMovementResponse.builder()
                .balancePay(pay)
                .feeToPay(credit.getCreditFee()
                        - response.stream().mapToInt(AllMovementViewResponse::getFee).sum())
                .moneyToPay((credit.getValueFee().multiply(new BigDecimal(credit.getCreditFee()))).subtract(pay))
                .code(credit.getCode())
                .build();
    }

}
