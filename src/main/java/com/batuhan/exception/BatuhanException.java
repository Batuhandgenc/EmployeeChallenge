package com.batuhan.exception;

import lombok.Getter;

@Getter
public class BatuhanException extends RuntimeException{
    private final ErrorType errorType;

    public BatuhanException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public BatuhanException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
