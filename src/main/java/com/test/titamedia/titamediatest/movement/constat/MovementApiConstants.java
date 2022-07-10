package com.test.titamedia.titamediatest.movement.constat;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MovementApiConstants {

    public static final String SUCCESS_TEXT = "Pay success";
    public static final String BALANCE_NOT_VALID = "Balance cannot be better than 0";
    public static final String CREDIT_PAYMENT = "credit payment completed";

    private MovementApiConstants() {

    }

    @Getter
    @AllArgsConstructor
    public enum Status {
        CANCEL("0", "Cancel");
        private final String code;
        private final String name;
    }

}
