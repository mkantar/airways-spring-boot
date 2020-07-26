package com.kantar.airways.common.exception;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {
    private Long exceptionId;

    public BusinessException(Long exceptionId) {
        this.exceptionId = exceptionId;
    }

    public BusinessException(Long exceptionId, String message) {
        super(message);
        this.exceptionId = exceptionId;
    }

    public BusinessException(Long exceptionId, String message, Throwable cause) {
        super(message, cause);
        this.exceptionId = exceptionId;
    }

    public Long getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(Long exceptionId) {
        this.exceptionId = exceptionId;
    }
}
