package com.kantar.airways.common.exception;

public class NotFoundException extends RuntimeException {
    private String message = "Not found";

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
