package com.sinem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_SERVER_ERROR(1000, "Sunucuda bilinmeyen bir hata olustu.", HttpStatus.INTERNAL_SERVER_ERROR),
    NAME_IS_NULL(1001, "Name alani bos gecilemes", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1002, "Geçersiz token", HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1001, "Aradığınız id'ye ait kayit bulunamamıştır", HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
