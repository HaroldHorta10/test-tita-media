package com.test.titamedia.titamediatest.persistence.impl;

import com.test.titamedia.titamediatest.credit.constat.CreditApiConstants;
import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.domain.CreditRequest;
import com.test.titamedia.titamediatest.credit.domain.CreditResponse;
import com.test.titamedia.titamediatest.credit.port.ICreditService;
import com.test.titamedia.titamediatest.persistence.entities.ClientBankCreditEntity;
import com.test.titamedia.titamediatest.persistence.entities.CreditEntity;
import com.test.titamedia.titamediatest.persistence.repositories.ClientBankCreditJpaRepository;
import com.test.titamedia.titamediatest.persistence.repositories.CreditJpaRepository;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CreditServiceImpl implements ICreditService {
    private final CreditJpaRepository repository;
    private final ClientBankCreditJpaRepository clientBankCreditJpaRepository;

    public CreditServiceImpl(CreditJpaRepository repository, ClientBankCreditJpaRepository clientBankCreditJpaRepository) {
        this.repository = repository;
        this.clientBankCreditJpaRepository = clientBankCreditJpaRepository;
    }

    @Override
    public CreditResponse save(CreditRequest bank) {
        CreditEntity save = repository.save(toCreditEntity(bank));
        clientBankCreditJpaRepository.save(toCreditBankEntity(bank, save.getCode()));
        return CreditResponse.buildWithCodeAndText(String.valueOf(HttpStatus.CREATED.value()), CreditApiConstants.SUCCESS_TEXT);
    }

    @Override
    public Credit consult(String credit) throws DataNotFoundPersistenceException {
        return toCredit(Optional.ofNullable(repository.findAllByCode(credit))
                .orElseThrow(() -> new DataNotFoundPersistenceException(HttpStatus.NOT_FOUND, CreditApiConstants.CREDIT_NO_FOUND)));
    }

    @Override
    public List<Credit> findAll() {
        return repository.findAll().stream().map(this::toCredit).collect(Collectors.toList());
    }

    private CreditEntity toCreditEntity(CreditRequest creditRequest) {
        return CreditEntity.builder()
                .code(String.valueOf(UUID.randomUUID().hashCode() & Integer.MAX_VALUE))
                .creditFee(creditRequest.getCreditFee())
                .balanceTotal(creditRequest.getBalanceTotal())
                .financialInterest(creditRequest.getFinancialInterest())
                .valueFee(
                        calculateValueFee(creditRequest.getBalanceTotal(),
                                creditRequest.getFinancialInterest(),
                                creditRequest.getCreditFee()))
                .build();
    }

    private Credit toCredit(CreditEntity entity) {
        return Credit.builder()
                .code(entity.getCode())
                .creditFee(entity.getCreditFee())
                .balanceTotal(entity.getBalanceTotal())
                .valueFee(entity.getValueFee())
                .build();
    }

    private ClientBankCreditEntity toCreditBankEntity(CreditRequest creditRequest, String code) {
        return ClientBankCreditEntity.builder()
                .documentNumber(creditRequest.getDocumentNumber())
                .idBank(creditRequest.getIdBank())
                .idCredit(code)
                .build();
    }

    private BigDecimal calculateValueFee(BigDecimal value, Double financial, Integer fee) {
        BigDecimal total = value.add(value.multiply(BigDecimal.valueOf(financial / 100)));
        return total.divide(new BigDecimal(fee), 2, RoundingMode.DOWN);
    }

}
