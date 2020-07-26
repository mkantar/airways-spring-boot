package com.kantar.airways.common.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public class BaseResponse implements Serializable {
    private boolean success = Boolean.TRUE;
    private Integer errorCode;
    private String errorMessage;
    private Instant timestamp = Instant.now();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
