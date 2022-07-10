package com.test.titamedia.titamediatest.movement.port;

import com.test.titamedia.titamediatest.movement.domain.AllMovementResponse;
import com.test.titamedia.titamediatest.movement.domain.MovementResponse;
import com.test.titamedia.titamediatest.movement.domain.PayRequest;
import com.test.titamedia.titamediatest.movement.usecase.MovementConsultUseCase;
import com.test.titamedia.titamediatest.movement.usecase.MovementSaveUseCase;
import com.test.titamedia.titamediatest.shared.constants.RestConstants;
import com.test.titamedia.titamediatest.shared.exceptions.ServiceGeneralException;
import com.test.titamedia.titamediatest.shared.exceptions.DataNotFoundPersistenceException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "pay")
@RequestMapping(value = RestConstants.API_VERSION_1 + RestConstants.MOVEMENT, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@CrossOrigin(origins = "*")
public class PayController {
    private final MovementSaveUseCase movementSaveUseCase;
    private final MovementConsultUseCase consultUseCase;


    public PayController(MovementSaveUseCase movementSaveUseCase, MovementConsultUseCase consultUseCase) {
        this.movementSaveUseCase = movementSaveUseCase;
        this.consultUseCase = consultUseCase;
    }

    @Operation(summary = "pay save")
    @PostMapping
    ResponseEntity<MovementResponse> save(@RequestBody PayRequest payRequest) throws DataNotFoundPersistenceException, ServiceGeneralException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movementSaveUseCase.save(payRequest));
    }

    @Operation(summary = "pay consult")
    @GetMapping(value = "/{credit}")
    ResponseEntity<AllMovementResponse> save(@PathVariable String credit) throws ServiceGeneralException, DataNotFoundPersistenceException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(consultUseCase.consultMovement(credit));
    }
}
