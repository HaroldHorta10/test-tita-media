package com.test.titamedia.titamediatest.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseOperation {

    private List<ExceptionResponse> operationOutcome;

}
