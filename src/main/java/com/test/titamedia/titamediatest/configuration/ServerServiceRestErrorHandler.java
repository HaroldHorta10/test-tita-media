package com.test.titamedia.titamediatest.configuration;

import com.test.titamedia.titamediatest.shared.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
public class ServerServiceRestErrorHandler {

    private static final String NOT_MESSAGE = "not message";

    @ExceptionHandler({DataNotFoundPersistenceException.class})
    @ResponseBody
    public ResponseEntity<ExceptionResponse> processValidationError(DataNotFoundPersistenceException ex) {
        log.error(ex.getClass().getName(), Optional.ofNullable(ex.getLocalizedMessage()).orElse(NOT_MESSAGE));

        ExceptionResponse response = new ExceptionResponse();

        if (!ObjectUtils.isEmpty(ex)) {
            response.setCode(String.valueOf(ex.getStatusCode().value()));
            response.setText(ex.getMessage());
        }
        log.error(Optional.ofNullable(ex.getMessage()).orElse(NOT_MESSAGE), ex);
        log.error(ExceptionUtils.getStackTrace(ex));

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler({ServiceGeneralException.class})
    @ResponseBody
    public ResponseEntity<ExceptionResponse> processValidationErrorBalance(ServiceGeneralException ex) {
        log.error(ex.getClass().getName(), Optional.ofNullable(ex.getLocalizedMessage()).orElse(NOT_MESSAGE));

        ExceptionResponse response = new ExceptionResponse();

        if (!ObjectUtils.isEmpty(ex)) {
            response.setCode(String.valueOf(ex.getStatusCode().value()));
            response.setText(ex.getMessage());
        }
        log.error(Optional.ofNullable(ex.getMessage()).orElse(NOT_MESSAGE), ex);
        log.error(ExceptionUtils.getStackTrace(ex));

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<ResponseOperation> processValidationError(final ValidationException ex) {

        log.error(ex.getClass().getName(), Optional.ofNullable(ex.getLocalizedMessage()).orElse(NOT_MESSAGE));

        List<ExceptionResponse> exceptionResponses = new ArrayList<>();
        ResponseOperation response = new ResponseOperation();


        ex.getValidationErrors().forEach(validationError -> {
            ExceptionResponse exceptionResponse = new ExceptionResponse();

            exceptionResponse.setCode(String.valueOf(validationError.getCode()));
            exceptionResponse.setText(validationError.getDetail());

            exceptionResponses.add(exceptionResponse);
        });

        response.setOperationOutcome(exceptionResponses);

        log.error(Optional.ofNullable(ex.getMessage()).orElse(NOT_MESSAGE), ex);
        log.error(ExceptionUtils.getStackTrace(ex));

        return ResponseEntity.badRequest().body(response);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String paramExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                return fieldError.getDefaultMessage();
            }
        }
        return "Error de parámetro de solicitud";
    }


}
