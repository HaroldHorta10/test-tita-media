package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.port.IBankService;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankConsultUseCaseImplTest {

    private BankConsultUseCaseImpl bankConsultUseCase;
    @Mock
    private IBankService service;

    @BeforeEach
    void setUp() {
        bankConsultUseCase = new BankConsultUseCaseImpl(service);
    }

    @Test
    void bankShouldBe() throws DataNotFoundPersistenceException {
        Bank expected = Bank.builder().code("001")
                .name("BankOpita")
                .build();
        when(service.consult(1))
                .thenReturn(expected);
        Bank result = bankConsultUseCase.consult(1);
        assertEquals(expected.getCode(), result.getCode());
        assertEquals(expected.getName(), result.getName());
    }

    @Test
    void bankShouldBeListed() throws DataNotFoundPersistenceException {
        List<Bank> expected = List.of(
                Bank.builder().code("001").name("BankOpita").build(),
                Bank.builder().code("002").name("BankJuarez").build()

        );
        when(service.findAll())
                .thenReturn(expected);
        List<Bank> result = bankConsultUseCase.findAll();
        assertEquals(expected.size(), result.size());
        assertEquals(expected.get(0), result.get(0));
    }
}