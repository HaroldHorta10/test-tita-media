package com.test.titamedia.titamediatest.credit.usecase;

import com.test.titamedia.titamediatest.bank.usecase.BankConsultUseCase;
import com.test.titamedia.titamediatest.client.usecase.ClientConsultUseCase;
import com.test.titamedia.titamediatest.credit.domain.CreditRequest;
import com.test.titamedia.titamediatest.credit.domain.CreditResponse;
import com.test.titamedia.titamediatest.credit.port.ICreditService;
import com.test.titamedia.titamediatest.movement.constat.MovementApiConstants;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditSaveUseCaseImpl implements CreditSaveUseCase {
    private final ICreditService creditService;
    private final ClientConsultUseCase consultUseCase;
    private final BankConsultUseCase bankConsultUseCase;

    public CreditSaveUseCaseImpl(ICreditService creditService, ClientConsultUseCase consultUseCase, BankConsultUseCase bankConsultUseCase) {
        this.creditService = creditService;
        this.consultUseCase = consultUseCase;
        this.bankConsultUseCase = bankConsultUseCase;
    }

    @Override
    public CreditResponse save(CreditRequest creditRequest) throws DataNotFoundPersistenceException, ServiceGeneralException {
        if(creditRequest.getBalanceTotal().signum() < 0){
            throw new ServiceGeneralException(HttpStatus.BAD_REQUEST, MovementApiConstants.BALANCE_NOT_VALID);
        }
        consultUseCase.consult(creditRequest.getDocumentNumber());
        bankConsultUseCase.consult(creditRequest.getIdBank());

        return creditService.save(creditRequest);
    }
}
