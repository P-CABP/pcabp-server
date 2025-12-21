package com.pcabp.core.common.exception;

import lombok.Getter;

@Getter
public class RestException extends RuntimeException {

    private final String messageKey;

    private final String[] labelKeys;

    public RestException(String messageKey) {
        this.messageKey = messageKey;
        this.labelKeys = null;
    }

    public RestException(String messageKey, String... labelKeys) {
        this.messageKey = messageKey;
        this.labelKeys = labelKeys;
    }

    public boolean hasMessageKey() {
        return messageKey != null;
    }

    public boolean hasLabelCodes() {
        return labelKeys != null && labelKeys.length > 0;
    }
}
