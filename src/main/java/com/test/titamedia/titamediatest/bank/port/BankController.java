package com.test.titamedia.titamediatest.bank.port;

import com.test.titamedia.titamediatest.bank.domain.Bank;
import com.test.titamedia.titamediatest.bank.usecase.BankConsultUseCase;
import com.test.titamedia.titamediatest.bank.usecase.BankSaveUseCase;
import com.test.titamedia.titamediatest.shared.constants.RestConstants;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Bank")
@RequestMapping(value = RestConstants.API_VERSION_1 + RestConstants.BANK, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "*")
public class BankController {
    private final BankSaveUseCase bankSaveUseCase;
    private final BankConsultUseCase bankConsultUseCase;

    public BankController(BankSaveUseCase bankSaveUseCase, BankConsultUseCase bankConsultUseCase) {
        this.bankSaveUseCase = bankSaveUseCase;
        this.bankConsultUseCase = bankConsultUseCase;
    }

    @Operation(summary = "Bank save")
    @PostMapping
    ResponseEntity<Bank> save(@RequestBody Bank bank) throws ServiceGeneralException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bankSaveUseCase.save(bank));
    }

    @Operation(summary = "Bank all")
    @GetMapping
    ResponseEntity<List<Bank>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bankConsultUseCase.findAll());
    }
}
