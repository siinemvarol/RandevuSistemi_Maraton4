package com.sinem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> hatalariYakalayanBenim(Exception ex){
        return new ResponseEntity<>(createErrorMessage(ex, ErrorType.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Java8StartException.class)
    public ResponseEntity<ErrorMessage> Java8StartExceptionHandler(Java8StartException ex){
        return new ResponseEntity<>(createErrorMessage(ex, ex.getErrorType()), ex.getErrorType().getHttpStatus());
    }

    /**
     * Tum hatalar belli bir metod uzerinde gectigi icin ek kodlamalar yapmadan
     * tek bir yerden olusan hatalarin loglanmasi ve veritabanina kayit edilmesini
     * kolaylastirir.
     *
     */
    private ErrorMessage createErrorMessage(Exception ex, ErrorType errorType){
        System.out.println("Hata oluştu...." +
                System.currentTimeMillis() + " - " + ex.toString()
        );
        return ErrorMessage.builder()
                .message(errorType.getMessage())
                .code(errorType.getCode())
                .build();
    }
}
