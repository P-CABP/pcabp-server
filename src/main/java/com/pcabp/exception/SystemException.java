package com.pcabp.exception;

public class SystemException extends RestException {

    public SystemException(String messageKeyCode) {
        super(messageKeyCode);
    }

    public SystemException(String messageKey, String... labelKeys) {
        super(messageKey, labelKeys);
    }
}
