package com.test.titamedia.titamediatest.bank.usecase;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.port.IBankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankSaveUseCaseImplTest {

    private BankSaveUseCaseImpl useCase;
    @Mock
    private IBankService service;

    @BeforeEach
    void setUp() {
        useCase = new BankSaveUseCaseImpl(service);
    }

    @Test
    void saveBank() {
        Bank expected = Bank.builder().code("001")
                .name("BankOpita")
                .build();
        when(service.save(expected))
                .thenReturn(expected);
        assertDoesNotThrow(() -> useCase.save(expected));
    }
}