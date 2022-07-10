package com.test.titamedia.titamediatest.credit.port;

import com.test.titamedia.titamediatest.credit.domain.Credit;
import com.test.titamedia.titamediatest.credit.domain.CreditRequest;
import com.test.titamedia.titamediatest.credit.domain.CreditResponse;
import com.test.titamedia.titamediatest.credit.usecase.CreditConsultUseCase;
import com.test.titamedia.titamediatest.credit.usecase.CreditSaveUseCase;
import com.test.titamedia.titamediatest.shared.constants.RestConstants;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "credit")
@RequestMapping(value = RestConstants.API_VERSION_1 + RestConstants.CREDIT, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "*")
public class CreditController {
    private final CreditSaveUseCase creditSaveUseCase;
    private final CreditConsultUseCase consultUseCase;

    public CreditController(CreditSaveUseCase creditSaveUseCase, CreditConsultUseCase consultUseCase) {
        this.creditSaveUseCase = creditSaveUseCase;
        this.consultUseCase = consultUseCase;
    }

    @Operation(summary = "credit save")
    @PostMapping
    ResponseEntity<CreditResponse> save(@RequestBody CreditRequest creditRequest) throws DataNotFoundPersistenceException, ServiceGeneralException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(creditSaveUseCase.save(creditRequest));
    }

    @Operation(summary = "credit all")
    @GetMapping
    ResponseEntity<List<Credit>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(consultUseCase.findAll());
    }
}
