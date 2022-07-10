package com.test.titamedia.titamediatest.clientbankcredit.port;

import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByBankCredit;
import com.test.titamedia.titamediatest.clientbankcredit.domain.ClientBankCreditByClientCredit;
import com.test.titamedia.titamediatest.clientbankcredit.usecase.ClientBankCreditConsultUseCase;
import com.test.titamedia.titamediatest.shared.constants.RestConstants;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Consult")
@RequestMapping(value = RestConstants.API_VERSION_1 + RestConstants.CONSULT, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "*")
public class ClientBankCreditController {
    private final ClientBankCreditConsultUseCase consultUseCase;

    public ClientBankCreditController(ClientBankCreditConsultUseCase consultUseCase) {
        this.consultUseCase = consultUseCase;
    }

    @Operation(summary = "client consult")
    @GetMapping("bank/client/{document}")
    ResponseEntity<List<ClientBankCreditByClientCredit>> consult(@PathVariable String document) throws DataNotFoundPersistenceException {
        return ResponseEntity.ok(consultUseCase.consult(document));
    }

    @Operation(summary = "Bank consult")
    @GetMapping("bank/{nameOrCode}")
    ResponseEntity<List<ClientBankCreditByBankCredit>> consultBank(@PathVariable String nameOrCode) throws DataNotFoundPersistenceException {
        return ResponseEntity.ok(consultUseCase.consultBank(nameOrCode));
    }

    @Operation(summary = "Bank and client consult")
    @GetMapping("bank/{nameOrCode}/client/{document}")
    ResponseEntity<List<ClientBankCreditByBankCredit>> consultBankAndClient(@PathVariable String nameOrCode, @PathVariable String document) {
        return ResponseEntity.ok(consultUseCase.consultBankAndClient(nameOrCode, document));
    }

}
