package com.quaint.blog.config.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一异常类(未编写)
 */
public class BusinessException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

    protected String errorCode;
    protected String[] errorMessageArguments;

    protected BusinessException() {
        this("");
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public static BusinessException withErrorCode(String errorCode) {
        BusinessException businessException = new BusinessException();
        businessException.errorCode = errorCode;
        return businessException;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String[] getErrorMessageArguments() {
        return this.errorMessageArguments = errorMessageArguments;
    }

    public BusinessException withErrorMessageArguments(String... errorMessageArguments) {
        if(errorMessageArguments != null) {
            this.errorMessageArguments = errorMessageArguments;
        }

        return this;
    }

}
