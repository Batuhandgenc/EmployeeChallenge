package com.batuhan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    CALISAN_BULUNAMADI(1003,"Çalışan Bulunamadı", INTERNAL_SERVER_ERROR),
    FIRMA_BULUNAMADI(1004,"Firma Bulunamadı", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;

}
