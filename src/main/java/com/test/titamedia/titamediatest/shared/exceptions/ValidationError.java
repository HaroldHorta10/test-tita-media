package com.test.titamedia.titamediatest.shared.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ValidationError {
    private String  code;
    private String detail;
}
