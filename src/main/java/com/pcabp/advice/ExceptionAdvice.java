package com.pcabp.advice;

import com.pcabp.exception.BusinessException;
import com.pcabp.exception.ClientException;
import com.pcabp.exception.RestException;
import com.pcabp.exception.SystemException;
import com.pcabp.helper.MessageTranslator;
import com.pcabp.model.RestResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final MessageTranslator messageTranslator;

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<RestResponse<String>> handleClientException(ClientException exception) {
        String errorMessage = translateMessage(exception);
        log.error("Client Exception : {}", errorMessage);
        return ResponseEntity.badRequest().body(RestResponse.ofFailure(errorMessage));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<RestResponse<String>> handleBusinessException(BusinessException exception) {
        String errorMessage = translateMessage(exception);
        log.error("BusinessException : {}", errorMessage);
        return ResponseEntity.internalServerError().body(RestResponse.ofFailure(errorMessage));
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<RestResponse<String>> handleSystemException(SystemException exception) {
        String errorMessage = translateMessage(exception);
        log.error("System Exception : {}", errorMessage, exception);
        return ResponseEntity.internalServerError().body(RestResponse.ofFailure(errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse<String>> handleException(Exception exception) {
        log.error("Unhandled Exception : {}", exception.getMessage());
        log.error("Exception Log : ", exception);

        String errorMessage = messageTranslator.translate("Message.EXCEPTION_INTERNAL_SERVER_ERROR");
        return ResponseEntity.internalServerError().body(RestResponse.ofFailure(errorMessage));
    }

    private String translateMessage(RestException exception) {
        if (exception.hasMessageKey() && exception.hasLabelCodes()) {
            return messageTranslator.translate(exception.getMessageKey(), exception.getLabelKeys());
        }

        if (exception.hasMessageKey()) {
            return messageTranslator.translate(exception.getMessageKey());
        }

        return exception.getMessageKey();
    }
}
