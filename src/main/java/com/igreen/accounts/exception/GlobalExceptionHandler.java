package com.igreen.accounts.exception;

import com.igreen.accounts.util.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public @ResponseBody
    AccountResponse handleResourceNotFound(final ResourceNotFoundException exception,
                                           final HttpServletRequest request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.NO_CONTENT.value());
        accountResponse.setError(HttpStatus.NO_CONTENT.name());
        accountResponse.setMessage(exception.getMessage());
        return accountResponse;
    }

    @ExceptionHandler({APIException.class, Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    AccountResponse handleException(final Exception exception, final HttpServletRequest request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        accountResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
        accountResponse.setMessage(exception.getMessage());
        return accountResponse;
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    AccountResponse handleInvalidInputException(final Exception exception,
                                                final HttpServletRequest request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        accountResponse.setError("Invalid input received");
        accountResponse.setMessage(exception.getMessage());
        return accountResponse;


    }
}