package com.test.titamedia.titamediatest.allcredit.usecase;

import com.test.titamedia.titamediatest.allcredit.domain.AllCredit;
import com.test.titamedia.titamediatest.allcredit.port.IAllCreditService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AllCreditConsultUseCaseImpl implements AllCreditConsultUseCase {
    private final IAllCreditService allCreditService;

    public AllCreditConsultUseCaseImpl(IAllCreditService allCreditService) {
        this.allCreditService = allCreditService;
    }


    @Override
    public List<AllCredit> consult(String document) throws DataNotFoundPersistenceException {
        return allCreditService.consult(document);
    }
}
