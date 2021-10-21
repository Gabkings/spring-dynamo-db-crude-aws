package com.gab.employee.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
