package com.test.titamedia.titamediatest.client.port;

import com.test.titamedia.titamediatest.client.domain.Client;
import com.test.titamedia.titamediatest.client.usecase.BankSaveUseCase;
import com.test.titamedia.titamediatest.client.usecase.ClientConsultUseCase;
import com.test.titamedia.titamediatest.shared.constants.RestConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "client")
@RequestMapping(value = RestConstants.API_VERSION_1 + RestConstants.CLIENT, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "*")
public class ClientController {
    private final BankSaveUseCase bankSaveUseCase;
    private final ClientConsultUseCase consultUseCase;

    public ClientController(BankSaveUseCase bankSaveUseCase, ClientConsultUseCase consultUseCase) {
        this.bankSaveUseCase = bankSaveUseCase;
        this.consultUseCase = consultUseCase;
    }

    @Operation(summary = "client save")
    @PostMapping
    ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bankSaveUseCase.save(client));
    }

    @Operation(summary = "client all")
    @GetMapping
    ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(consultUseCase.consult());
    }
}
