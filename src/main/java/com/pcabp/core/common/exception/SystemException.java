package com.pcabp.core.common.exception;

public class SystemException extends RestException {

    public SystemException(String messageKeyCode) {
        super(messageKeyCode);
    }

    public SystemException(String messageKey, String... labelKeys) {
        super(messageKey, labelKeys);
    }
}
