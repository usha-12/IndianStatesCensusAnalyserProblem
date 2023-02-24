package com.brideglabz.indianstatescensusanalyser;
public class CustomException extends Exception {
    public enum ExceptionType {
        FILE_NOT_FOUND,
        FILE_TYPE_MISMATCH,
        DELIMETER_INCORRECT,
        HEADER_MISMATCH;
    }
    final ExceptionType type;
    public CustomException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
