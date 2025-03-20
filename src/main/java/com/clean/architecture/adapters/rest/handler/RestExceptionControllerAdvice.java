package com.clean.architecture.adapters.rest.handler;

import com.clean.architecture.domain.exception.CustomHttpErrorCode;
import com.clean.architecture.domain.exception.NotFoundException;
import com.clean.architecture.domain.exception.ValidationException;
import com.generated.swaggerCodegen.model.BackendErrorResponse;
import com.generated.swaggerCodegen.model.MetaData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;


@ControllerAdvice
@Slf4j
public class RestExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            ValidationException.class
    })
    protected ResponseEntity<BackendErrorResponse> validationError(ValidationException ex, WebRequest request) {
        return new ResponseEntity<>(
                getErrorResponse(
                        request,
                        ex.getMessage(),
                        CustomHttpErrorCode.BAD_REQUEST.toString()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {
            NotFoundException.class
    })
    protected ResponseEntity<BackendErrorResponse> notFoundError(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                getErrorResponse(
                        request, ex.getMessage(),
                        CustomHttpErrorCode.NOT_FOUND.toString()
                ), HttpStatus.NOT_FOUND
        );
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        return new ResponseEntity<>(
                getErrorResponse(
                        request, ex.getMessage(),
                        CustomHttpErrorCode.BAD_REQUEST.toString()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {
            RuntimeException.class
    })
    protected ResponseEntity<BackendErrorResponse> handleConflictInternalError(Throwable ex, WebRequest request) {
        log.error("{}", ex);
        return new ResponseEntity<>(
                getErrorResponse(
                        request,
                        "Oops! Неизвестная проблема",
                        CustomHttpErrorCode.INTERNAL_SERVER_ERROR.toString()
                ), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    public BackendErrorResponse getErrorResponse(final WebRequest request, final String msg, final String errorCode) {
        BackendErrorResponse response = new BackendErrorResponse();
        MetaData meta = new MetaData();
        meta.setTimestamp(Instant.now().toString());
        meta.setPath(((ServletWebRequest) request).getRequest().getServletPath());

        response.setMeta(meta);
        response.setErrorCode(errorCode);
        response.setDescription(msg);
        return response;
    }

    public BackendErrorResponse getErrorResponse(final HttpServletRequest request, final String msg, final String errorCode) {
        BackendErrorResponse response = new BackendErrorResponse();
        MetaData meta = new MetaData();
        meta.setTimestamp(Instant.now().toString());
        meta.setPath(request.getServletPath());

        response.setMeta(meta);
        response.setErrorCode(errorCode);
        response.setDescription(msg);
        return response;
    }
}

