package com.sinem.randevu.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_SERVER_ERROR(1000, "Sunucuda bilinmeyen bir hata olustu.", HttpStatus.INTERNAL_SERVER_ERROR),
    ID_NOT_FOUND(1001, "Aradığınız id'ye ait kayit bulunamamıştır", HttpStatus.BAD_REQUEST),
    RANDEVU_DOLU(1003, "Randevu almak istediğiniz tarih ve saat doludur. Lütfen başka bir saat için tekrar deneyin.", HttpStatus.BAD_REQUEST),

    GECERSIZ_SAAT(1003, "Sadece 9 ve 17 saatleri aralığında randevu alınabilir. Lütfen başka bir saat için tekrar deneyin.", HttpStatus.BAD_REQUEST),
    GECERSIZ_TARIH(1004, "Geçmiş bir tarihe randevu alınamaz. Lütfen başka bir tarih için tekrar deneyin.", HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
