package com.test.titamedia.titamediatest.persistence.repositories;

import com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByBankResponse;
import com.test.titamedia.titamediatest.persistence.entities.ClientBankCreditEntity;
import com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByClientResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ClientBankCreditJpaRepository extends PagingAndSortingRepository<ClientBankCreditEntity, Long> {

    @Query(value = "select distinct" +
            " new com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByClientResponse (b.code, b.name, cbc.documentNumber) " +
            "from ClientBankCreditEntity cbc\n" +
            "join BankEntity b on b.id = cbc.idBank where cbc.documentNumber =:document")
    List<ClientBankCreditByClientResponse> findAllByDocumentNumber(String document);

    @Query(value = "select distinct" +
            " new com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByBankResponse (b.code, b.name, cbc.documentNumber,c.code) " +
            "from ClientBankCreditEntity cbc\n" +
            "join BankEntity b on b.id = cbc.idBank " +
            "join CreditEntity c on c.code = cbc.idCredit " +
            "where b.name like '%' || :nameOrCode || '%' or b.code=:nameOrCode")
    List<ClientBankCreditByBankResponse> findAllByBank(String nameOrCode);

    @Query(value = "select distinct" +
            " new com.test.titamedia.titamediatest.persistence.domain.ClientBankCreditByBankResponse (b.code, b.name, cbc.documentNumber,c.code) " +
            "from ClientBankCreditEntity cbc\n" +
            "join BankEntity b on b.id = cbc.idBank " +
            "join CreditEntity c on c.code = cbc.idCredit " +
            "where b.name like '%' || :nameOrCode || '%' or b.code=:nameOrCode and cbc.documentNumber=:document")
    List<ClientBankCreditByBankResponse> findAllByBankAndClient(String nameOrCode, String document);
}
