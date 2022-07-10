package com.test.titamedia.titamediatest.movement.usecase;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.usecase.CreditConsultUseCase;
import com.test.titamedia.titamediatest.movement.constat.MovementApiConstants;
import com.test.titamedia.titamediatest.movement.domain.MovementResponse;
import com.test.titamedia.titamediatest.movement.domain.MovementResult;
import com.test.titamedia.titamediatest.movement.domain.PayRequest;
import com.test.titamedia.titamediatest.movement.port.IPayService;
import com.test.titamedia.titamediatest.persistence.entities.AllMovementViewEntity;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class MovementSaveUseCaseImpl implements MovementSaveUseCase {
    private final IPayService creditService;
    private final CreditConsultUseCase consultUseCase;

    public MovementSaveUseCaseImpl(IPayService creditService, CreditConsultUseCase consultUseCase) {
        this.creditService = creditService;
        this.consultUseCase = consultUseCase;
    }

    @Override
    public MovementResponse save(PayRequest payRequest) throws DataNotFoundPersistenceException, ServiceGeneralException {
        if (payRequest.getBalance().signum() < 0) {
            throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, MovementApiConstants.BALANCE_NOT_VALID);
        }
        Credit credit = consultUseCase.consult(payRequest.getCreditId());

        validatePay(payRequest, credit);
        MovementResult movementResult = creditService.save(payRequest).getResult();
        List<AllMovementViewEntity> all = creditService.consult(payRequest.getCreditId());
        BigDecimal pending = getPending(all, credit);
        return MovementResponse.builder()
                .creditFee(getFee(all, pending, credit))
                .balancePending(pending)
                .result(movementResult)
                .build();
    }

    private BigDecimal getPending(List<AllMovementViewEntity> all, Credit credit) {
        BigDecimal total = credit.getValueFee().multiply(new BigDecimal(credit.getCreditFee()));
        BigDecimal totalPay = all
                .stream()
                .map(AllMovementViewEntity::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total.subtract(totalPay);
    }

    private String getFee(List<AllMovementViewEntity> all, BigDecimal pending, Credit credit) {
        String fee;
        if (pending.compareTo(BigDecimal.ZERO) < 0) {
            fee = MovementApiConstants.Status.CANCEL.getName();
        } else {
            fee = String.valueOf(credit.getCreditFee() -
                    all.stream()
                            .mapToInt(AllMovementViewEntity::getFee)
                            .sum());
        }
        return fee;
    }

    void validatePay(PayRequest payRequest, Credit credit) throws ServiceGeneralException {
        List<AllMovementViewEntity> all = creditService.consult(payRequest.getCreditId());

        String format = "the value of the loan to be paid is %f";
        if (payRequest.getCreditFeeToPay() == 0 && ObjectUtils.isEmpty(all)) {
            BigDecimal calculateValue = credit.getValueFee()
                    .multiply(new BigDecimal(credit.getCreditFee()));
            if (calculateValue.doubleValue() != payRequest.getBalance().doubleValue()) {
                throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, String.format(format, calculateValue));
            }
        }
        if (payRequest.getCreditFeeToPay() == 0 && !ObjectUtils.isEmpty(all)) {
            BigDecimal calculateValue = getPending(all, credit);
            if (calculateValue.doubleValue() != payRequest.getBalance().doubleValue()) {
                throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, String.format(format, calculateValue));
            }
        }
        BigDecimal calculateValue = credit.getValueFee()
                .multiply(new BigDecimal(payRequest.getCreditFeeToPay()));

        if (calculateValue.doubleValue() != payRequest.getBalance().doubleValue()) {
            throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, String.format(format, calculateValue));
        }

        if (!ObjectUtils.isEmpty(all) && getPending(all, credit).compareTo(BigDecimal.ZERO) <= 0) {
            throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, MovementApiConstants.CREDIT_PAYMENT);
        }


    }
}
